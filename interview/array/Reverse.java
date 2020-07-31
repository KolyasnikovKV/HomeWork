package array;

import java.util.Arrays;

public class Reverse {

    public static void main(String[] args){

        int[] resource = {1, 2, 2, 3, 4, 5, 5, 6};
        System.out.println(Arrays.toString(resource));

        for (int i = 0; i < resource.length / 2; i++) {
            int buff = resource[i];
            resource[i] = resource[resource.length - i - 1];
            resource[resource.length - i - 1] = buff;
        }
        System.out.println(Arrays.toString(resource));
    }
}
