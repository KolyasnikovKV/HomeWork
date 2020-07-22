import jdk.internal.org.objectweb.asm.tree.InnerClassNode;

import java.util.HashMap;
import java.util.Map;

public class MyFibonachi {

    private static Map<Integer, Integer> cachefib = new HashMap<Integer, Integer>();

    public static int Fibonachi(int i1){

        if (i1 == 0) {
            return 0;
        }
        if (i1 == 1) {
            return 1;
        }

        if (cachefib.containsKey(i1)) {
            return cachefib.get(i1);
        }

        int Fib = Fibonachi(i1 - 1) + Fibonachi(i1 - 2);
        cachefib.put(i1, Fib);
        System.out.println(Fib);
        return Fib;
    }

    public static void main(String[] args){
        System.out.println("ЦИКЛ");
        int i1 = 0;
        int i2 = 1;
        int i3 = 0;
        System.out.println(i1);
        System.out.println(i2);
        for (int i = 0; i <= 10; i++) {
            i3 = i1 + i2;
            i1 = i2;
            i2 = i3;
            System.out.println(i3);
        }
        System.out.println("РЕКУРСИЯ");
        i3 = Fibonachi(10);
                         // 5 -> 4 + 3  (8)
                // 4 -> 3 + 2 (5)              // 3 -> 2 + 1 (3)
        // 3 -> 2 + 1   2 -> 1 + 0            2 -> 1 + 0     (1)
        //    (3)           (2)                    (1)
        // Это дерево высотой 2^N  с кэшем до N
    }
}
