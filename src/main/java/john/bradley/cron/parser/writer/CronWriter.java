package john.bradley.cron.parser.writer;

import john.bradley.cron.parser.cronfields.CronField;

import static com.google.common.base.Preconditions.checkArgument;

public class CronWriter {

    private CronWriter() {
    }

    public static String getAllValues(CronField field) {
        return getMatchingValues(field, field.getMinValue(), 1);
    }

    public static String getMatchingValues(CronField field, int increment) {
        return getMatchingValues(field, increment, increment);
    }

    public static String getMatchingValues(CronField field, int startValue, int increment) {
        checkArgument(startValue <= field.getMaxValue(), "startValue must be less than max value");
        checkArgument(startValue >= field.getMinValue(), "startValue must be greater than min value");


        String writtenValues = Integer.toString(startValue);
        int nextValue = startValue + increment;
        while (nextValue <= field.getMaxValue()) {
            writtenValues = writtenValues + " " + nextValue;
            nextValue += increment;
        }
        return writtenValues;
    }

    public static String getValuesInRange(CronField field, int startValue, int endValue) {
        //TODO: Should only return one value if range is 0 (i.e. 1-1 should return 1, not 1-1)
        checkArgument(startValue <= field.getMaxValue(), "startValue must be less than max value");
        checkArgument(startValue <= endValue, "startValue must be less than endValue");
        checkArgument(startValue >= field.getMinValue(), "startValue must be greater than min value");

        String writtenValues = Integer.toString(startValue);

        for (int i = startValue+1; i <= endValue; i++){
            writtenValues = writtenValues + " " + i;
        }
        return writtenValues;
    }
}
