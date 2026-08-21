class Solution {
    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(daysFrom1900(date1) - daysFrom1900(date2));
    }

    private int daysFrom1900(String date) {
        String[] parts = date.split("-");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);

        int days = 0;

        // Add days for all complete years since 1900
        for (int y = 1900; y < year; y++) {
            days += isLeapYear(y) ? 366 : 365;
        }

        // Add days for all complete months in the current year
        int[] daysInMonths = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int m = 1; m < month; m++) {
            if (m == 2 && isLeapYear(year)) {
                days += 29;
            } else {
                days += daysInMonths[m];
            }
        }

        // Add the remaining days of the current month
        days += day;

        return days;
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
