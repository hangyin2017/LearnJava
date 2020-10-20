import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.zip.CheckedOutputStream;

/**
 * Java Core p.214
 * Use reflection to print out all features of a class.
 *
 * Example:
 * Input: java.lang.Double
 * Output:
 * public final java.lang.Double extends class java.lang.Number {
 *
 *     public static final double java.lang.Double.POSITIVE_INFINITY
 *     public static final double java.lang.Double.NEGATIVE_INFINITY
 *     (... rest fields)
 *
 *     public java.lang.Double(double)
 *     public java.lang.Double(java.lang.String) throws java.lang.NumberFormatException
 *
 *     public boolean java.lang.Double.equals(java.lang.Object)
 *     public static java.lang.String java.lang.Double.toString(double)
 *     public java.lang.String java.lang.Double.toString()
 *     (... rest methods)
 * }
 *
 * 2020/10/20
 */
public class ReflectionTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type a class name: (eg. java.util.Date)");
        String className = scanner.next();

        try {
            Class cl = Class.forName(className);
            printDefinition(cl);
            System.out.println();

            printFields(cl);
            System.out.println();

            printConstructors(cl);
            System.out.println();

            printMethods(cl);

            System.out.println("}");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printDefinition(Class cl) {
        String modifierString = Modifier.toString(cl.getModifiers());
        if (modifierString.length() > 0) {
            System.out.print(modifierString + " ");
        }
        System.out.print(cl.getName());
        Class superClass = cl.getSuperclass();
        if (superClass != null && superClass != Object.class)
            System.out.print(" extends " + superClass);
        System.out.print(" {\n");
    }

    private static void printFields(Class cl) {
        Field[] fields = cl.getDeclaredFields();
        Arrays.stream(fields).forEach(field -> {
            System.out.println("    " + field.toString());
        });
    }

    private static void printConstructors(Class cl) {
        Constructor[] constructors = cl.getDeclaredConstructors();
        Arrays.stream(constructors).forEach(constructor -> {
            System.out.println("    " + constructor.toString());
        });
    }

    private static void printMethods(Class cl) {
        Method[] methods = cl.getDeclaredMethods();
        Arrays.stream(methods).forEach(method -> {
            System.out.println("    " + method.toString());
        });
    }
}
