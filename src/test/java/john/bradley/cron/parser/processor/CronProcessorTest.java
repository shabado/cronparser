package john.bradley.cron.parser.processor;

import john.bradley.cron.parser.cronfields.impl.CronMinuteField;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CronProcessorTest {

    @Test
    public void should_return_correct_string_based_on_cronField() throws Exception {
        CronProcessor processor = new CronProcessor();

        String expected = "1 16 31 46";

        String values = processor.parseCronString("1/15", CronMinuteField.class);
        assertEquals(expected, values);
    }

    //need tests to check multiple, i.e 1-3,4,2/5 and tests for other input types
}
