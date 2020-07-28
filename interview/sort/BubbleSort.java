package sort;
import java.util.Arrays;
public class BubbleSort {

    public static void main(String args[]) {
        int[] test = {5, 3, 2, 1, 4};
        bubbleSort(test);
    }

    public static void bubbleSort(int[] sorted){
        System.out.println(Arrays.toString(sorted));
        boolean isNeedIteration = true;
        while (isNeedIteration) {
            isNeedIteration = false;
            for (int i = 0; i < sorted.length - 1; i++) {
                if (sorted[i + 1] < sorted[i]) {
                    int temp = sorted[i];
                    sorted[i] = sorted[i + 1];
                    sorted[i + 1] = temp;
                    isNeedIteration = true;
                }

            }
        }
        System.out.printf(Arrays.toString(sorted));
    }
}
