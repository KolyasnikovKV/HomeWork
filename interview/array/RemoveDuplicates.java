package array;

import java.lang.reflect.Array;
import java.util.Arrays;

public class RemoveDuplicates {

    public static void main(String args[]) {
        remove(new int[] {2, 6, 9, 5, 7, 5, 13, 10, 5, 10});
    }

    public static void remove(int[] array){

        Arrays.sort(array);
        int[] result = new int[array.length];
        int previous = array[0];
        result[0] = previous;

        for(int i = 1; i < array.length; i++){

            if (array[i] != previous){
                result[i] = array[i];
            }

            previous = array[i];
        }

        System.out.printf("(%s) %n", Arrays.toString(result));
    }
}
