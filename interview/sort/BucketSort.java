package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BucketSort {
    public static void main(String[] args){
        int[] input = new int[]{80, 50, 30, 10, 90, 60, 0, 70, 40, 20, 50};
        System.out.println(Arrays.toString(input));
        sortBucket(input);
        System.out.println(Arrays.toString(input));

    }

    public static void sortBucket(int[] input){

        final int[] code = hash(input);

        List[] buckets = new List[code[1]];

        for(int i = 0; i < code[1]; i++){
            buckets[i] = new ArrayList();
        }

        for(int i : input){
            buckets[hash(i, code)].add(i);
        }

        for(List bucket : buckets){
            Collections.sort(bucket);
        }

        int ndx = 0;
        for(int b = 0; b < buckets.length; b++ ){
            for (Object v : buckets[b]){
                input[ndx++] = (Integer) v;

            }

        }
    }

    private static int[] hash(int[] input){

        int m = input[0];
        for(int i = 1; i < input.length; i++){
            if(m < input[i]){
                m = input[i];
            }
        }
        return new int[] {m, (int)  Math.sqrt(input.length)};
    }

    private static int hash(int i, int []code){
        return (int) ((double) i / code[0] * (code[1] - 1));
    }


}
