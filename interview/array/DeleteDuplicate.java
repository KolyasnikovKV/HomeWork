package array;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class DeleteDuplicate {

    public static boolean haveValue(int[] arr, int value){
        for(int i = 0; i < arr.length; i++){
            if (arr[i] == value) return true;
        }
        return false;
    }

    public static int[] newArr(int[] arr){
        int[] newArr = new int[arr.length + 1];
        for(int i = 0; i < arr.length; i++){
            newArr[i] = arr[i];
        }
        return newArr;
    }

    //вариант 2
    public static void removeDuplicates(Integer[] arr){
        Arrays.sort(arr);
        Integer[] newArr = new Integer[arr.length];
        int previous = arr[0];
        newArr[0] = previous;
        for (int i = 1; i < arr.length; i++){
            if (arr[i] != previous){
                newArr[i] = arr[i];
                }
            previous = arr[i];
        }

        System.out.println(Arrays.toString(newArr));
    }


    public static void main(String[] args){
        Integer[] arr = {1, 2, 2, 3, 4, 5, 5, 6};
        //сохранит
        Set<Integer> set = new LinkedHashSet<Integer>();
        for (int item: arr){
            set.add(item);
        }
        System.out.println(set.toString());

        int[] resource = {1, 2, 2, 3, 4, 5, 5, 6};
        int[] result = new int[1];
        result[0] = resource[0];
        int resultIndex = 1;
        for(int i = 1; i < resource.length; i++){
            if (!haveValue(result, resource[i])){
                result = newArr(result);
                result[resultIndex++] = resource[i];
            }

        }
        System.out.println(Arrays.toString(result));

        removeDuplicates(arr);

    }
}
