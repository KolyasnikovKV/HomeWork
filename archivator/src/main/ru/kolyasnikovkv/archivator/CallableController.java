package main.ru.kolyasnikovkv.archivator;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.zip.*;

public class CallableController {

    private int countThreads;
    volatile ZipOutputStream zipOutputStream;

    private CallableController() {}

    public CallableController(int countThreads) {
        this.countThreads = countThreads;
    }

    public void mArchive(DataInputStream dataInput) throws IOException {

        ExecutorService executor = Executors.newCachedThreadPool();
        List<Future<ReturnedValue>> futures;
        futures = new ArrayList<Future<ReturnedValue>>();
        ReturnedValue[] returnedValues;

        byte[] buffer = new byte[1024];
        int readLen = -1;
        int position = 0;
        while ((readLen = dataInput.read(buffer)) != -1) {
            Archiver2 archiver = new Archiver2(buffer.clone(), position); // без клоне все работали с одним буфером
            FutureTask futureTask = new FutureTask(archiver);
            Future<ReturnedValue> future = executor.submit(archiver);
            futures.add(future);
            position++;
            System.out.println(position);
        }

        executor.shutdown();

        while (!executor.isTerminated()){
           // System.out.println("Ожидаю завершения потоков!");
        }

        returnedValues = new ReturnedValue[futures.size()];
        int zipSize = 0;
        CRC32 crc = new CRC32();
        for (Future<ReturnedValue> item : futures) {
            try {
             ReturnedValue returnedValue  = item.get();
             returnedValues[returnedValue.position] = returnedValue;
             byte[] buffer2 = returnedValue.byteOutput;
             zipSize = zipSize + buffer2.length;
             crc.update(buffer2);
            }catch(InterruptedException e) {
                System.out.println(e);
                return;
            } catch(ExecutionException e) {
                System.out.println(e);
            }
        }

        zipOutputStream = prepareZipFile(zipSize, crc);
        FileOutputStream fos = new FileOutputStream("compressed.gz");
        for (ReturnedValue item : returnedValues) {
            byte[] buffer2 = item.byteOutput;
            zipOutputStream.write(buffer2, 0, buffer2.length);
            fos.write(buffer2, 0, buffer2.length);
        }
        fos.close();
        zipOutputStream.closeEntry();
        zipOutputStream.close();
        System.out.println("successful");

    }

    private ZipOutputStream prepareZipFile(int zipSize, CRC32 crc) throws IOException {
        FileOutputStream fos = new FileOutputStream("compressed.zip");
        ZipOutputStream zipOut = new ZipOutputStream(fos);
        zipOut.setMethod(ZipOutputStream.STORED);
        ZipEntry zipEntry = new ZipEntry("compressed.txt");
        zipEntry.setSize(zipSize);
        zipEntry.setCrc(crc.getValue());
        zipOut.putNextEntry(zipEntry);
        return zipOut;
    }

    private byte[] getPart(byte[] file, int start, int finish) {
        return Arrays.copyOfRange(file, start, finish);
    }

}
