package sort;

import java.util.Arrays;

public class InsertionSort {

    public static void insertSort(int[] arr){

        for(int i = 1; i < arr.length; i++){
            int numberToInsert = arr[i];

            int compareIndex = i;
            //while (j > 0 && objArray[j - 1].compareTo(objectToSort) > 1) {
            while(compareIndex > 0 && arr[compareIndex - 1] > numberToInsert){
                arr[compareIndex] = arr[compareIndex - 1];
                compareIndex--;
            }

            arr[compareIndex] = numberToInsert;
            System.out.println(Arrays.toString(arr));
        }

    }

    public static void main(String[] arg){

        int[] arr =  new int[] {6, 8, 2, 3, 8, 5, 13, 11, 5, 2};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
