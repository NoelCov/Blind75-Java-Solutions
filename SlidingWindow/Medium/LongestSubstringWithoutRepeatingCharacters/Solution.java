// Question link: https://leetcode.com/problems/longest-substring-without-repeating-characters/

class Solution {
    // Time Complexity O(n)
    // Space Complexity O(n)
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        StringBuilder sb = new StringBuilder();

        int res = 0;
        int start = 0;
        int end = 0;

        sb.append(s.substring(start, end + 1));

        while (end < s.length() - 1) {
            end++;
            String currChar = "" + s.charAt(end);
            if (sb.indexOf(currChar) != -1) {
                // This means that we have this character.
                start = sb.indexOf(currChar) + 1;
                res = Math.max(res, sb.length());
                sb.delete(0, start);
            }
            sb.append(s.charAt(end));
        }
        return Math.max(res, sb.length());
    }
}