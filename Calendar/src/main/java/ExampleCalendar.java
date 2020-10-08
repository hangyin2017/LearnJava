import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;


/**
 * Java 核心思想 Core Java p.103
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

    /**
     * Print month days from the first day of month.
     */
    public static void printMonthDays(Calendar date) {
        int today = date.get(Calendar.DAY_OF_MONTH);
        int month = date.get(Calendar.MONTH);
        int lastDayOfWeek = getLastDayOfWeek(date);

        printIndent(calculateIndent(date));

        Calendar monthDay = (Calendar)date.clone();
        monthDay.set(Calendar.MONTH, month);
        monthDay.set(Calendar.DAY_OF_MONTH, 1);
        for (; monthDay.get(Calendar.MONTH) == month; monthDay.add(Calendar.DAY_OF_MONTH, 1)) {
            System.out.printf("%3d", monthDay.get(Calendar.DAY_OF_MONTH));
            if (monthDay.get(Calendar.DAY_OF_MONTH) == today) System.out.print("*");
            else System.out.print(" ");
            if (monthDay.get(Calendar.DAY_OF_WEEK) == lastDayOfWeek) System.out.println();
        }
    }

    /**
     * Calculate the indent before the first day of month.
     */
    public static int calculateIndent(Calendar date) {
        int indent = 0;
        Calendar firstDayOfMonth = (Calendar)date.clone();
        firstDayOfMonth.set(Calendar.DAY_OF_MONTH, 1);

        int firstDayOfWeek = firstDayOfMonth.getFirstDayOfWeek();
        int dayOfWeek = firstDayOfMonth.get(Calendar.DAY_OF_WEEK);

        while (dayOfWeek != firstDayOfWeek) {
            indent++;
            firstDayOfMonth.add(Calendar.DAY_OF_MONTH, -1);
            dayOfWeek = firstDayOfMonth.get(Calendar.DAY_OF_WEEK);
        }

        return indent;
    }

    public static void printIndent(int indent) {
        for (; indent > 0; indent--) {
            System.out.printf("%4s", " ");
        }
    }

    public static int getLastDayOfWeek(Calendar date) {
        Calendar lastDayOfWeek = (Calendar)date.clone();

        lastDayOfWeek.set(Calendar.DAY_OF_WEEK, date.getFirstDayOfWeek());
        lastDayOfWeek.add(Calendar.DAY_OF_WEEK, -1);

        return lastDayOfWeek.get(Calendar.DAY_OF_WEEK);
    }

}
