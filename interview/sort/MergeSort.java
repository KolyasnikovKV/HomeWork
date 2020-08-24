package sort;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.Arrays;

public class MergeSort {
    public static void main(String [] arg){
        int[] input = {87, 57, 370, 110, 90, 610, 02, 710, 140, 203, 150};

        System.out.println(Arrays.toString(input));
        sortmerge(input);
        System.out.println(Arrays.toString(input));

    }

    public static void sortmerge(int[] arr){
        sortmerge(arr, 0, arr.length - 1);
    }

    public static void sortmerge(int[] arr, int start, int end){
       int mid = (start + end) / 2;
       if (start < end){
           sortmerge(arr, start, mid);
           sortmerge(arr, mid + 1, end);
       }

       int i = 0, first = start, first2 = mid + 1;
       int[] tmp = new int [end - start + 1];

       while (first <= mid && first2 <= end){
           tmp[i++] = arr[first] < arr[first2] ? arr[first++] : arr[first2++];
       }

       while(first <= mid){
           tmp[i++] = arr[first++];
       }
       while(first2 <= end){
           tmp[i++] = arr[first2++];
       }
       i = 0;
       while(start <= end){
           arr[start++] = tmp[i++];
       }
    }
}
