import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] s = new int[n];

        for (int i = 0; i < n; i++) {
            s[i] = sc.nextInt();
        }

        int d = sc.nextInt(); // Ron's birth day
        int m = sc.nextInt(); // Ron's birth month

        int count = 0;

        // Check every contiguous segment of length m
        for (int i = 0; i <= n - m; i++) {
            int sum = 0;

            for (int j = i; j < i + m; j++) {
                sum += s[j];
            }

            if (sum == d) {
                count++;
            }
        }

        System.out.println(count);

        sc.close();
    }
}
