import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;


/**
 * Core Java p.103
 * Print a monthly calendar.
 *  Sun Mon Tue Wed Thu Fri Sat
 *                   1   2   3
 *   4   5   6   7*  8   9  10
 *  11  12  13  14  15  16  17
 *  18  19  20  21  22  23  24
 *  25  26  27  28  29  30  31
 *
 * 2020/10/06
 */
public class ExampleCalendar {

    public static void main(String[] args) {
        Calendar date = new GregorianCalendar();

        printShortWeekdays(getShortWeekdays(Locale.US));
        printMonthDays(date);
    }

    public static String[] getShortWeekdays(Locale locale) {
        return new DateFormatSymbols(locale).getShortWeekdays();
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
        printIndent(calculateIndent(date));

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

    public static int calculateIndent(Calendar firstDayOfMonth) {
        int indent = 0;
        int firstDayOfWeek = firstDayOfMonth.getFirstDayOfWeek();
        int weekday = firstDayOfMonth.get(Calendar.DAY_OF_WEEK);

        while (weekday != firstDayOfWeek) {
            indent++;
            firstDayOfMonth.add(Calendar.DAY_OF_MONTH, -1);
            weekday = firstDayOfMonth.get(Calendar.DAY_OF_WEEK);
        }

        return indent;
    }

    public static void printIndent(int indent) {
        for (; indent > 0; indent--) {
            System.out.printf("%4s", " ");
        }
    }

    public static void getLastDayOfWeek(Calendar date) {

    }

}
