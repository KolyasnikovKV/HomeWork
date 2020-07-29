package array;

import com.sun.org.apache.bcel.internal.generic.LineNumberGen;

import java.util.HashSet;
import java.util.Set;

public class ArrayMaxMin {
    public static void main(String args[]) {
        brutForce(new int[] {2, 6, 9, 5, 7, 5, 13, 10, 5, 10});
    }

    public static void brutForce(int[] array){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < array.length; i++){
            if (array[i] > max){
                max = array[i];
            }
            if (array[i] < min){
                min = array[i];
            }

        }

        System.out.printf("(%d, %d) %n", max, min);
    }
}
