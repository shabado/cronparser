package john.bradley.cron.parser.cronfields.impl;

import john.bradley.cron.parser.cronfields.CronField;

public class CronMonthField implements CronField {

    public int getMinValue() {
        return 1;
    }

    public int getMaxValue() {
        return 12;
    }
}

