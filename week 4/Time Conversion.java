import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String time = sc.next();

        String period = time.substring(8);
        int hour = Integer.parseInt(time.substring(0, 2));

        if (period.equals("AM")) {
            if (hour == 12) {
                hour = 0;
            }
        } else {
            if (hour != 12) {
                hour += 12;
            }
        }

        System.out.printf("%02d%s%n", hour, time.substring(2, 8));

        sc.close();
    }
}
