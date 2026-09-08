class Solution {
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        int count1 = 0, count2 = 0;

        for (int i = 0; i < n / 2; i++) {
            if (isVowel(s.charAt(i))) {
                count1++;
            }
        }

        for (int i = n / 2; i < n; i++) {
            if (isVowel(s.charAt(i))) {
                count2++;
            }
        }

        return count1 == count2;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' ||
               c == 'o' || c == 'u' ||
               c == 'A' || c == 'E' || c == 'I' ||
               c == 'O' || c == 'U';
    }
}
