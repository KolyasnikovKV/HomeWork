package array;

public class MyArray {

    /// 1 + 2 + 3 + 4
    ///+
    /// n + n-1 + n-2
    //  n * (n+1) / 2 арифмет прогр

    // с геометр с - 1 / с - 1 * (1 + с2 + с3 + + + ) многое сократиться
    // (с^n+1 - 1) / (c - 1)
    public static int propusk(int[] numbers, int total){
        int sum100 = total * (total + 1) / 2;
        int sum = 0;
        for (int item : numbers) {
            sum += item;
        }

        System.out.println(sum100);
        System.out.println(sum);
        return sum100 - sum;
    }

    public static void main(String[] args){
        System.out.println(propusk(new int[]{1, 2, 3, 4, 6}, 6));
    }
}
