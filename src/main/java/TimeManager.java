public class TimeManager {
    private final String format24;
    private final String format12;
    boolean isValid = false;

    TimeManager(String time) {
        int hour = Integer.parseInt(time.substring(0, 2));
        int minute = Integer.parseInt(time.substring(2, 4));

        if (hour >= 0 && hour <= 23) {
            if (minute >= 0 && minute <= 59) {
                this.isValid = true;
            }
        }

        this.format24 = time;

        String postfix = "";

        if (this.isValid) {
            if (hour > 11) {
                postfix += "pm";
            } else {
                postfix += "am";
            }

            if (hour > 12) {
                hour -= 12;
            }

            this.format12 = String.format("%d:%02d%s", hour, minute, postfix);
        } else {
            this.format12 = "";
        }
    }

    public boolean isTimeValid() {
        return this.isValid;
    }

    public String getFormat12() {
        return this.format12;
    }
}
