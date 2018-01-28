package john.bradley.cron.parser.cronfields.impl;

import john.bradley.cron.parser.cronfields.CronField;

public class CronDayOfWeekField implements CronField {

    public int getMinValue() {
        return 0;
    }

    public int getMaxValue() {
        return 6;
    }
}

