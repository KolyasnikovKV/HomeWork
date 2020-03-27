package main.ru.kolyasnikovkv.archivator;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.zip.ZipOutputStream;

public class Archiver implements Callable<Integer> {

    private CountDownLatch latch;
    private byte[] partFile;
    private ZipOutputStream zipOutputStream;
    private int start;

    Archiver(CountDownLatch countDownLatch,
             byte[] partBytes, ZipOutputStream zipOutputStream, int start) {
        this.latch = countDownLatch;
        this.partFile = partBytes;
        this.zipOutputStream = zipOutputStream;
        this.start = start;
    }

    public Integer call() {
        try {
            synchronized (zipOutputStream) {
                zipBytes();
            }
            //System.out.println(new String(partFile, 0, partFile.length));
            //System.out.println(start);
            latch.countDown();
        } catch (Exception err) {
            err.printStackTrace();
        }
        return start;
    }

    private void zipBytes() throws IOException {
        zipOutputStream.write(partFile, 0, partFile.length);
    }
}
