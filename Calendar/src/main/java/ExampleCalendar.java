import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;


/**
 * Java 核心技术 p.103
 * CalendarTest
 * 打印日历
 * 2020/10/06
 */
public class ExampleCalendar {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        Calendar date = new GregorianCalendar();

        printShortWeekdays(getShortWeekdays());
        printMonthDays(date);

    }

    public static String[] getShortWeekdays() {
        return new DateFormatSymbols().getShortWeekdays();
    }

    public static void printShortWeekdays(String[] shortWeekDays) {

        for (String shortWeekDay : shortWeekDays) {
            if(!shortWeekDay.equals(""))
            System.out.printf("%4s", shortWeekDay);
        }
        System.out.println();

    }

    public static void printMonthDays(Calendar date) {

        int today = date.get(Calendar.DAY_OF_MONTH);
        int month = date.get(Calendar.MONTH);

        date.set(Calendar.DAY_OF_MONTH, 1);
        int weekday = date.get(Calendar.DAY_OF_WEEK);
        int indent = 0;
        int firstDayOfWeek = date.getFirstDayOfWeek();

        while (weekday != firstDayOfWeek) {
            indent++;
            date.add(Calendar.DAY_OF_MONTH, -1);
            weekday = date.get(Calendar.DAY_OF_WEEK);
        }

        for (; indent > 0; indent--) {
            System.out.printf("%4s", " ");
            date.add(Calendar.DAY_OF_MONTH, 1);
        }

        date.set(Calendar.DAY_OF_WEEK, firstDayOfWeek);
        date.add(Calendar.DAY_OF_WEEK, -1);
        int lastDayOfWeek = date.get(Calendar.DAY_OF_WEEK);
        date.set(Calendar.MONTH, month);
        date.set(Calendar.DAY_OF_MONTH, 1);
        for (; date.get(Calendar.MONTH) == month; date.add(Calendar.DAY_OF_MONTH, 1)) {
            System.out.printf("%3d", date.get(Calendar.DAY_OF_MONTH));
            if (date.get(Calendar.DAY_OF_MONTH) == today) System.out.print("*");
            else System.out.print(" ");
            if (date.get(Calendar.DAY_OF_WEEK) == lastDayOfWeek) System.out.println();
        }

    }
}
