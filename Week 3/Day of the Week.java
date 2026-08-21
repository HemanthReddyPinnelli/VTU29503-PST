import java.util.*;

public class Solution {
    
    private static final int[] DAYS_IN_MONTH = {31,28,31,30,31,30,31,31,30,31,30,31};
    private static final String[] WEEK = {"Friday","Saturday","Sunday","Monday","Tuesday","Wednesday","Thursday"};
    
    public static String dayOfTheWeek(int day, int month, int year) {
        int totalDays = 0;
        
        // 1. days from years
        for (int y = 1971; y < year; y++) {
            totalDays += isLeap(y) ? 366 : 365;
        }
        
        // 2. days from months of current year
        for (int m = 1; m < month; m++) {
            totalDays += DAYS_IN_MONTH[m - 1];
            if (m == 2 && isLeap(year)) { // February in leap year
                totalDays += 1;
            }
        }
        
        // 3. days in current month
        totalDays += day - 1;
        
        // 4. map to day name
        return WEEK[totalDays % 7];
    }
    
    private static boolean isLeap(int y) {
        return (y % 400 == 0) || (y % 4 == 0 && y % 100 != 0);
    }
    
    // for local testing
    public static void main(String[] args) {
        System.out.println(dayOfTheWeek(31, 8, 2019)); // Saturday
        System.out.println(dayOfTheWeek(18, 7, 1999)); // Sunday
        System.out.println(dayOfTheWeek(15, 8, 1993)); // Sunday
        System.out.println(dayOfTheWeek(1, 1, 1971));  // Friday
    }
}
