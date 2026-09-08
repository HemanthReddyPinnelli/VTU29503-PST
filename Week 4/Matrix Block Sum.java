class Solution {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] result = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int sum = 0;

                int r1 = Math.max(0, i - K);
                int r2 = Math.min(m - 1, i + K);
                int c1 = Math.max(0, j - K);
                int c2 = Math.min(n - 1, j + K);

                for (int r = r1; r <= r2; r++) {
                    for (int c = c1; c <= c2; c++) {
                        sum += mat[r][c];
                    }
                }

                result[i][j] = sum;
            }
        }

        return result;
    }
}
