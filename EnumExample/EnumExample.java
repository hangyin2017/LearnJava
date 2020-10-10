import java.util.Scanner;

/**
 * Core Java p.208
 * Display emun element and its abbreviation set by the constructor.
 * 2020/10/10
 */
public class EnumExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a size: (SMALL, MEDIUM, LARGE, EXTRA_LARGE)");

        String input = scanner.nextLine().toUpperCase();

        Size size = Enum.valueOf(Size.class, input);
        System.out.println("size: " + size);
        System.out.println("abbreviation: " + size.getAbbreviation());

        if (size == Size.EXTRA_LARGE)
            System.out.println("You pay attention to the '_'.");
    }

    enum Size {
        SMALL("S"),
        MEDIUM("M"),
        LARGE("L"),
        EXTRA_LARGE("XL");

        private String abbreviation;

        private Size(String abbreviation) {
            this.abbreviation = abbreviation;
        }

        public String getAbbreviation() { return this.abbreviation; }
    }
}