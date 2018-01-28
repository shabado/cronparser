package john.bradley.cron.parser.cronfields.impl;

import john.bradley.cron.parser.cronfields.CronField;

public class CronMinuteField implements CronField {

    public int getMinValue() {
        return 0;
    }

    public int getMaxValue() {
        return 59;
    }
}
