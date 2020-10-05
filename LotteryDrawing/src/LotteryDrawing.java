import java.lang.reflect.Array;
import java.util.*;

/**
 * Java 核心技术 p.99
 * Manipulate array.
 * 从 1 到 n 的数字组成的数组中随机抽取 k 个数并按大小排列打印
 * 2020/10/05
 */

public class LotteryDrawing {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many numbers (n) in the array?");
        int n = scanner.nextInt();
        int[] numbers = generateNumbers(n);

        System.out.println("How many numbers (k) do you want to draw?");
        int k = scanner.nextInt();
        int[] result = new int[k];

        /*
         * Pick random number in the given array.
         */
        for (int i = 0; i < k; i++) {
            int randomIndex = (int) (Math.random() * (n - i));
            result[i] = numbers[randomIndex];
            numbers[randomIndex] = numbers[n - i - 1];
        }

        printSortedArray(result);
    }

    /**
     * Generate an incremental array of n elements {1, 2, 3, ..., n}.
     */
    private static int[] generateNumbers(int n) {
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = i;
        }

        return numbers;
    }

    /**
     * Sort and print out an array.
     */
    private static void printSortedArray(int[] array) {
        Arrays.sort(array);

        for (int n : array) {
            System.out.println(n);
        }

        // Alternatively:
        //System.out.println(Arrays.toString(result));
    }
}
