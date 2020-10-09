package FindMax.src;

public class FindMax {

    public static void main(String[] args) {
        double max = findMax(2.4, -40.2, 3332, -2982.33432);
        System.out.println(max);
    }

    public static double findMax(double... numbers) {
        double max = Double.MIN_VALUE;

        for (double n : numbers) {
            if (n > max) max = n;
        }

        return max;
    }
}