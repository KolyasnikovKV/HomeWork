package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RadixSort {
    public static void main(String[] arg){

        int[] input = {1, 2, 10, 11, 5, 4, 8, 12};
        System.out.println(Arrays.toString(input));
        sortRadix(input);
        System.out.println(Arrays.toString(input));
    }

    public static void sortRadix(int[] input){
        final int RADIX = 10;
        List<Integer>[] bucket = new ArrayList[RADIX];

        for(int i = 0; i < bucket.length; i++){
            bucket[i] = new ArrayList<Integer>();
        }

        //sort
        boolean maxLength = false;
        int tmp = -1, placement = 1;
        while (!maxLength){
            maxLength = true;

            //split input between lists
            for(Integer i : input){
                tmp = i / placement;
                bucket[tmp % RADIX].add(i);
                if(maxLength && tmp > 0){
                    maxLength = false;
                }
            }

            //empty lists into input array
            int a = 0;
            for(int b = 0; b < RADIX; b++){
                for(Integer i: bucket[b]){
                    input[a++] = i;
                }
                bucket[b].clear();
            }

            System.out.println(Arrays.toString(input));

            placement *= RADIX;
        }


    }
}
