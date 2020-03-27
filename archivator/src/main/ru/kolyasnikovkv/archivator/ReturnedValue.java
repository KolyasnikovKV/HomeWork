package main.ru.kolyasnikovkv.archivator;

import java.io.ByteArrayOutputStream;

public class ReturnedValue {
    public int position;
    public byte[] byteOutput;
    public ReturnedValue(int position, byte[]  byteOutput) {
        this.byteOutput = byteOutput;
        this.position = position;
       }
}
