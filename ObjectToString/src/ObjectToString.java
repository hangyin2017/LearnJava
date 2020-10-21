import java.util.Arrays;
import java.util.Date;

/**
 * Core Java p.221
 * Set private field accessible.
 */
public class ObjectToString {
    public static void main(String[] args) {
        toString(new Date());
    }

    public static void toString(Object obj) {
        Class cl = obj.getClass();

        Arrays.stream(cl.getDeclaredFields()).forEach(field -> {
            // Make private fields accessible so that field.get() can run.
            field.setAccessible(true);
            try {
                System.out.println(field.get(obj).toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
