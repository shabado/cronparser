package john.bradley.cron.parser.processor;

import com.google.common.base.Joiner;
import john.bradley.cron.parser.cronfields.CronField;
import john.bradley.cron.parser.writer.CronWriter;

import java.util.ArrayList;
import java.util.List;

public class CronProcessor {

    private CronField cronField;
    private static final String REGEX_DELIMITER = "((?<=[/\\-])|(?=[/\\-]))";

    public String parseCronString(String inputArg, Class<? extends CronField> cronType)
            throws InstantiationException, IllegalAccessException {
        cronField = cronType.newInstance();

        //Split on comma to get individual arguments
        String[] cronArgs = inputArg.split(",");

        List<String> cronStrings = new ArrayList<>();

        for (String cronArg : cronArgs) {
            cronStrings.add(createCronString(cronArg));
        }

        return Joiner.on(" ").join(cronStrings);
    }

    private String createCronString(String cronArg) {

        String[] splitCronArg = cronArg.split(REGEX_DELIMITER);

        switch (splitCronArg.length) {
            case 1: {
                if (splitCronArg[0].equals("*")) {
                    return CronWriter.getAllValues(cronField);
                }
                return splitCronArg[0];
            }
            case 3: {
                return createCronStringWithMultiArgs(splitCronArg);
            }
            default:
                //No other lengths are valid
                throw new IllegalArgumentException("cronArg is not valid: " + cronArg);
        }
    }

    private String createCronStringWithMultiArgs(String[] cronArgs) {
        switch (cronArgs[1]) {
            case "-": {
                return CronWriter.getValuesInRange(cronField,
                        Integer.parseInt(cronArgs[0]), Integer.parseInt(cronArgs[2]));
            }
            case "/": {
                int startValue = (cronArgs[0].equals("*")) ? 0 : Integer.parseInt(cronArgs[0]);
                return CronWriter.getMatchingValues(cronField, startValue, Integer.parseInt(cronArgs[2]));
            }
            default: {
                throw new IllegalArgumentException("cronArgs is not valid: " + cronArgs);
            }
        }
    }
}
