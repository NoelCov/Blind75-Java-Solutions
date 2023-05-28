// Question link: https://leetcode.com/problems/valid-palindrome/

// Time Complexity O(n log n)
// Space Complexity O(1)
class Solution {
    public boolean isPalindrome(String s) {
        // Remove all non-alpha numeric values
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");

        // Using a two-pointer approach move the outter of the array to the middle of
        // it.
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}