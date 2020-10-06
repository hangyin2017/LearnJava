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
        GregorianCalendar d = new GregorianCalendar();
        int firstDayOfWeek = d.getFirstDayOfWeek();
        printShortWeekdays(getShortWeekdays());
    }

    private static String[] getShortWeekdays() {
        return new DateFormatSymbols(Locale.US).getShortWeekdays();
    }

    private static void printShortWeekdays(String[] shortWeekDays) {
        for (String shortWeekDay : shortWeekDays) {
            System.out.printf("%4s", shortWeekDay);
        }
        System.out.println();
    }
}
