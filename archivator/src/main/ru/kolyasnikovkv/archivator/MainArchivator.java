package main.ru.kolyasnikovkv.archivator;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class MainArchivator {

    public static void main(String[] args) throws IOException{

        String fileName = args[0];


        MainArchivator mZipCreator = new MainArchivator();
        //byte[] bytes = mZipCreator.readFromFile(fileName);
        DataInputStream dataInput = mZipCreator.openInpurStream(fileName);

        CallableController controller = new CallableController(4);
        controller.mArchive(dataInput);

        //System.out.println(new String(bytes, 0, bytes.length));
    }

    private byte[] readFromFile(String fileName) throws IOException {
        FileInputStream in = new FileInputStream(fileName);
        DataInputStream dis = new DataInputStream(in);
        byte[] datainBytes = new byte[dis.available()];

        dis.readFully(datainBytes);
        dis.close();

        return datainBytes;
    }

    private DataInputStream openInpurStream(String fileName) throws IOException {

        /*try(FileInputStream fin=new FileInputStream("C://SomeDir//notes.txt"))
        {
            int i=-1;
            while((i=fin.read())!=-1){

                System.out.print((char)i);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }*/

        FileInputStream in = new FileInputStream(fileName);
        DataInputStream dis = new DataInputStream(in);

        return dis;
    }
}
