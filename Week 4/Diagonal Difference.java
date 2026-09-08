import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int primary = 0;
        int secondary = 0;

        for (int i = 0; i < n; i++) {
            primary += arr[i][i];
            secondary += arr[i][n - 1 - i];
        }

        System.out.println(Math.abs(primary - secondary));

        sc.close();
    }
}
