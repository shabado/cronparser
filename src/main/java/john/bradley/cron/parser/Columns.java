package john.bradley.cron.parser;

public enum Columns {
    MINUTE("Minute        "),
    HOUR("Hour          "),
    DAY_OF_MONTH("Day of Month  "),
    MONTH("Month         "),
    DAY_OF_WEEK("Day of Week   "),
    COMMAND("Command       ");

    private String value;

    Columns(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
