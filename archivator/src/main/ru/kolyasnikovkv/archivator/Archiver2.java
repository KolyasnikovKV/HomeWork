package main.ru.kolyasnikovkv.archivator;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.zip.GZIPOutputStream;

public class Archiver2 implements Callable<ReturnedValue> {

    private byte[] partFile;
    private int position;
    private byte[]  byteOutput;

    Archiver2(byte[] partBytes, int position) {
        this.partFile = partBytes;
        this.position = position;
    }

    public ReturnedValue call() {
        try {
            //synchronized (zipOutputStream) {
                zipBytes();
            //}
            //System.out.println(new String(partFile, 0, partFile.length));
            //System.out.println(start);
            //latch.countDown();
        } catch (Exception err) {
            err.printStackTrace();
        }
        return new ReturnedValue(position, byteOutput);
    }

    private void zipBytes() throws IOException {
        System.out.println("Поток " + position) ;
        ByteArrayOutputStream byteoutputStream = new ByteArrayOutputStream(0);
        GZIPOutputStream zipOutputStream = new GZIPOutputStream(byteoutputStream);
        zipOutputStream.write(partFile, 0, partFile.length);
        zipOutputStream.finish();
        byteOutput = byteoutputStream.toByteArray();
        zipOutputStream.close();
    }
}
