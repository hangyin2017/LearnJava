import java.math.*;
import java.util.*;

/**
 * Java 核心技术 p.77 BigIntegerTest
 * 2020/10/04
 * 计算从 n 个数中抽取 k 个中奖号码的中奖概率
 */

public class BigIntegerTest {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many numbers do you need to draw?");
        int k = scanner.nextInt();

        System.out.println("What's the highest number you can draw?");
        int n = scanner.nextInt();

        /*
         * p = n(n-1)(n-2)...(n-k+1)/k!
         */

        BigInteger p = BigInteger.valueOf(1);

        for(int i = 1; i <= k; i++) {
            p = p.multiply(BigInteger.valueOf(n - i + 1)).divide(BigInteger.valueOf(i));
        }

        System.out.println("Possibility of win: 1 in " + p);
    }
}