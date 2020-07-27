import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FindDoubleElementArray {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] ar = new int[size];
        for (int i = 0; i < size; i++){
            ar[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(ar));

        for(int i = 0; i < size; i++){
            for(int j = i + 1; j< size; j++){
                if (ar[i] == ar[j]){
                    System.out.print(i + " - ");
                    System.out.println(ar[i]);
                }
            }
        }

        // N2
        // Вариант 2

        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < size; i++){
            if (set.contains(ar[i])){
                System.out.println(ar[i]);
            }
            else
            {
                set.add(ar[i]);
            }
        }
    }
}
