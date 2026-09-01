import java.util.*;

class Solution {
    public String largestNumber(int[] nums) {
        // Convert to String array
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        // Sort with custom comparator
        Arrays.sort(arr, (a, b) -> {
            String order1 = a + b; // if we put a before b
            String order2 = b + a; // if we put b before a
            return order2.compareTo(order1); // descending
        });

        // Edge case: if the largest number is "0", the whole number is 0
        if (arr[0].equals("0")) {
            return "0";
        }

        // Join them
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s);
        }
        return sb.toString();
    }

    // For local testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.largestNumber(new int[]{10, 2})); // "210"
        System.out.println(sol.largestNumber(new int[]{3,30,34,5,9})); // "9534330"
        System.out.println(sol.largestNumber(new int[]{0,0})); // "0"
    }
}
