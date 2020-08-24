package sort;

import java.util.Arrays;

public class CountSort {


    public static void main(String[] args){
        int[] input = {60, 40, 30, 20, 10, 40, 30, 60, 60, 20, 40, 30, 40};
        int k = 60;

        System.out.println(Arrays.toString(input));
        sortCount(input, k);
        System.out.println(Arrays.toString(input));
    }

    public static void sortCount(int[] input, int k){
        //create buckets
        int[] counter =  new int[k + 1];

        //fill
        for(int i: input){
            counter[i]++;
        }

        //sort
        int ndx = 0;
        for(int i = 0; i < counter.length; i++ ){
            while(0 < counter[i])
            {
                input[ndx++] = i;
                counter[i]--;
            }
        }
    }
}
