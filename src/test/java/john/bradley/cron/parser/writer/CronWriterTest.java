package john.bradley.cron.parser.writer;

import john.bradley.cron.parser.cronfields.CronField;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CronWriterTest {

    private CronField field;

    @BeforeEach
    public void setUp() {
        field = mock(CronField.class);
        when(field.getMinValue()).thenReturn(0);
        when(field.getMaxValue()).thenReturn(10);
    }

    @Test
    public void getAllValues_should_return_all_values() {
        String expected = "0 1 2 3 4 5 6 7 8 9 10";
        String values = CronWriter.getAllValues(field);
        assertEquals(expected, values);
    }

    @Test
    public void getValues_should_return_correct_values() {
        String expected = "3 6 9";
        String values = CronWriter.getMatchingValues(field, 3);
        assertEquals(expected, values);
    }

    @Test
    public void getValues_should_return_correct_values_with_increment() {
        String expected = "5 7 9";
        String values = CronWriter.getMatchingValues(field, 5, 2);
        assertEquals(expected, values);
    }

    @Test
    public void getValuesInRange_should_return_all_values_in_range() {
        String expected = "2 3 4 5 6";
        String values = CronWriter.getValuesInRange(field, 2, 6);
        assertEquals(expected, values);
    }

    @Test
    public void getValues_should_throw_if_value_is_greater_than_max() {
        int value = field.getMaxValue() + 1;
        assertThrows(IllegalArgumentException.class, () -> {
            CronWriter.getMatchingValues(field, value);
        });
    }
}
