package main;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CallableController {

    private int countThreads;
    volatile ZipOutputStream zipOutputStream;

    private CallableController() {}

    public CallableController(int countThreads) {
        this.countThreads = countThreads;
    }

    public void mArchive(byte[] file) throws IOException {
        ExecutorService executor = Executors.newFixedThreadPool(countThreads);

        List<Future<Integer>> futures;
        CountDownLatch countDownLatch = new CountDownLatch(countThreads);
        zipOutputStream = prepareZipFile();

        futures = new ArrayList<Future<Integer>>();

        for(int i=0; i<countThreads; i++) {

            int start = i * file.length/countThreads;
            int finish = (i+1) * file.length/countThreads;

            Archiver archiver = new Archiver(countDownLatch, getPart(file, start, finish), zipOutputStream, start);
            Future<Integer> future = executor.submit(archiver);
            futures.add(future);

            try {
                System.out.println(future.get());
            }catch(InterruptedException e) {
                System.out.println(e);
                return;
            } catch(ExecutionException e) {
                System.out.println(e);
            }
        }

        executor.shutdown();

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        zipOutputStream.closeEntry();
        zipOutputStream.close();

        System.out.println("Обработка завершена!");
    }

    private ZipOutputStream prepareZipFile() throws IOException {
        FileOutputStream fos = new FileOutputStream("compressed.zip");
        ZipOutputStream zipOut = new ZipOutputStream(fos);
//        FileInputStream fis = new FileInputStream("");
        ZipEntry zipEntry = new ZipEntry("compressed.txt");
        zipOut.putNextEntry(zipEntry);
        return zipOut;
    }

    private byte[] getPart(byte[] file, int start, int finish) {
        return Arrays.copyOfRange(file, start, finish);
    }

}
