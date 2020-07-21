package main.ru.kolyasnikovkv.archivator;

import java.util.HashSet;
import java.util.Set;

public class Holder {
    private int n;
    public final Set<Integer> setInt;
    public Holder(int n) {
        setInt = new HashSet<Integer>();
        System.out.println("Holder");
        this.n = n; }
    public void assertSanity() {

        if (n != n)
            throw new AssertionError("Эта инструкция является ложной.");
    }
}
