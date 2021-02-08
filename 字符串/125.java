class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        if (n == 0) {
            return true;
        }
        int left = 0, right = n - 1;
        while (left < right) {
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                ++left;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(right))) {
                --right;
                continue;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }
}
