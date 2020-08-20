package sort;

import java.util.Arrays;

public class QuickSort {

    public static void quickSort(int[] arr, int left, int right){
        if (left > right) return;
        int middle = partinion(arr, left, right);
        quickSort(arr, left, middle - 1);
        quickSort(arr, middle + 1, right );
    }

    public static int partinion(int[] arr, int left, int right){

        int i = left;
        int j = left;

        for (j = left; j < right; j++ ) {
            if (arr[j] < arr[right]){
                if (i != j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                }
                i++;
            }
        }

        int temp = arr[i];
        arr[i] = arr[right];
        arr[right] = temp;

        return i;
    }

    public static void main(String[] arg){

        int[] arr =  new int[] {2, 6, 9, 10, 8, 5, 13, 11, 5, 7};
        int left = 0;
        int right = arr.length - 1;
        quickSort(arr, left, right);

        System.out.println(Arrays.toString(arr));

    }
}
