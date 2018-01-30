package john.bradley.cron.parser;

import john.bradley.cron.parser.cronfields.impl.CronDayOfMonthField;
import john.bradley.cron.parser.cronfields.impl.CronDayOfWeekField;
import john.bradley.cron.parser.cronfields.impl.CronHourField;
import john.bradley.cron.parser.cronfields.impl.CronMinuteField;
import john.bradley.cron.parser.cronfields.impl.CronMonthField;
import john.bradley.cron.parser.processor.CronProcessor;

import static com.google.common.base.Preconditions.checkArgument;

public class CronParser {

    public static void main(String[] args) throws Exception {

        checkArgument(args.length == 6, "Incorrect number of args: " + args.length);
        CronProcessor processor = new CronProcessor();

        String[] output = new String[] {
                processor.parseCronString(args[0], CronMinuteField.class),
                processor.parseCronString(args[1], CronHourField.class),
                processor.parseCronString(args[2], CronDayOfMonthField.class),
                processor.parseCronString(args[3], CronMonthField.class),
                processor.parseCronString(args[4], CronDayOfWeekField.class),
                args[5]
        };

        System.out.println(Columns.MINUTE.getValue() + output[0]);
        System.out.println(Columns.HOUR.getValue() + output[1]);
        System.out.println(Columns.DAY_OF_MONTH.getValue() + output[2]);
        System.out.println(Columns.MONTH.getValue() + output[3]);
        System.out.println(Columns.DAY_OF_WEEK.getValue() + output[4]);
        System.out.println(Columns.COMMAND.getValue() + output[5]);
    }

}
