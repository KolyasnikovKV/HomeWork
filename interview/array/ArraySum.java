package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArraySum {
    public static void main(String args[]) {
        usingSet(new int[] {2, 6, 9, 5, 7, 5, 13, 10, 5, 10}, 12);
        brutForce(new int[] {2, 6, 9, 5, 7, 5, 13, 10, 5, 10}, 12);
        twoPointer(new int[] {2, 6, 9, 5, 7, 5, 13, 10, 5, 10}, 12);
    }

    public static void usingSet(int[] array, int sum){
        Set<Integer> set = new HashSet<Integer>();

        for(int value: array){
            int target = sum - value;
            if(!set.contains(target)){
                set.add(value);
            }
            else
            {
                System.out.println(target + "-" + value);
            }
        }
    }


    public static void brutForce(int[] array, int sum){
        for(int i = 0; i < array.length; i++){
            for(int j = i; j < array.length; j++){
                if ((array[i] + array[j]) == sum){
                    System.out.printf("(%d, %d) %n", array[i], array[j]);
                }
            }
        }

    }

    public static void twoPointer(int[] array, int sum){
            Arrays.sort(array);
            int left = 0;
            int right = array.length -1;
            while(left < right){
                if ((array[left] + array[right]) == sum){
                    System.out.printf("(%d - %d) %n", array[left], array[right]);
                    left++;
                    right--;
                }
                else if (((array[left] + array[right]) < sum)) {
                    left++;
                }
                else if (((array[left] + array[right]) > sum)) {
                    right--;
                }
            }
    }

}
