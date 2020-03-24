package main;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadExecutor{

    public static void main(String[] args) throws IOException{

        String fileName = args[0];

        ThreadExecutor mZipCreator = new ThreadExecutor();
        byte[] bytes = mZipCreator.readFromFile(fileName);

        CallableController controller = new CallableController(4);
        controller.mArchive(bytes);

        //System.out.println(new String(bytes, 0, bytes.length));
    }

    /**
     * @param fileName
     * @return
     * @throws IOException
     */
    private byte[] readFromFile(String fileName) throws IOException {
        FileInputStream in = new FileInputStream(fileName);
        DataInputStream dis = new DataInputStream(in);
        byte[] datainBytes = new byte[dis.available()];

        dis.readFully(datainBytes);
        dis.close();

        return datainBytes;
    }
}
