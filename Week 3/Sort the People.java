import java.util.*;

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;

        // Create list of indices and sort them by height descending
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, (i, j) -> Integer.compare(heights[j], heights[i]));

        // Build result array using sorted indices
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[i] = names[indices[i]];
        }

        return result;
    }

    // For local testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.sortPeople(
            new String[]{"Mary","John","Emma"},
            new int[]{180,165,170}
        ))); // [Mary, Emma, John]

        System.out.println(Arrays.toString(sol.sortPeople(
            new String[]{"Alice","Bob","Bob"},
            new int[]{155,185,150}
        ))); // [Bob, Alice, Bob]
    }
}
