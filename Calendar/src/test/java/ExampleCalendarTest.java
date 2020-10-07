import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class ExampleCalendarTest {

    @Test
    public void testPrintShortWeekdays() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        ExampleCalendar.printShortWeekdays(ExampleCalendar.getShortWeekdays(Locale.US));

        System.setOut(null);

        assertEquals(" Sun Mon Tue Wed Thu Fri Sat\r\n", outContent.toString());
    }

    @Test
    public void testCalculateIndent() {

        Calendar date = new GregorianCalendar(2020, Calendar.OCTOBER, 1);

        assertEquals(4, ExampleCalendar.calculateIndent(date));

    }

}