import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ExampleCalendarTest {

    @Test
    public void testPrintShortWeekdays() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        ExampleCalendar.printShortWeekdays(ExampleCalendar.getShortWeekdays());

        System.setOut(null);

        assertEquals(" Sun Mon Tue Wed Thu Fri Sat\r\n", outContent.toString());
    }

}