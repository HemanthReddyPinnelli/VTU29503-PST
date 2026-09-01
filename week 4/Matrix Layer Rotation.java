import java.util.*;

public class Main {

    public static void matrixRotation(int[][] matrix, int r) {
        int m = matrix.length;
        int n = matrix[0].length;

        int layers = Math.min(m, n) / 2;

        for (int layer = 0; layer < layers; layer++) {

            List<Integer> elements = new ArrayList<>();

            int top = layer;
            int left = layer;
            int bottom = m - layer - 1;
            int right = n - layer - 1;

            // Top row: left -> right
            for (int j = left; j <= right; j++) {
                elements.add(matrix[top][j]);
            }

            // Right column: top+1 -> bottom
            for (int i = top + 1; i <= bottom; i++) {
                elements.add(matrix[i][right]);
            }

            // Bottom row: right-1 -> left
            for (int j = right - 1; j >= left; j--) {
                elements.add(matrix[bottom][j]);
            }

            // Left column: bottom-1 -> top+1
            for (int i = bottom - 1; i > top; i--) {
                elements.add(matrix[i][left]);
            }

            int len = elements.size();
            int shift = r % len;

            int index = 0;

            // Top row
            for (int j = left; j <= right; j++) {
                matrix[top][j] = elements.get((shift + index) % len);
                index++;
            }

            // Right column
            for (int i = top + 1; i <= bottom; i++) {
                matrix[i][right] = elements.get((shift + index) % len);
                index++;
            }

            // Bottom row
            for (int j = right - 1; j >= left; j--) {
                matrix[bottom][j] = elements.get((shift + index) % len);
                index++;
            }

            // Left column
            for (int i = bottom - 1; i > top; i--) {
                matrix[i][left] = elements.get((shift + index) % len);
                index++;
            }
        }

        // Print matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();
        int r = sc.nextInt();

        int[][] matrix = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        matrixRotation(matrix, r);

        sc.close();
    }
}
