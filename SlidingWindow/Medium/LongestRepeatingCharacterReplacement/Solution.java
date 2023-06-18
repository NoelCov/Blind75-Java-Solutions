package SlidingWindow.Medium.LongestRepeatingCharacterReplacement;

import java.util.*;

// Question link: https://leetcode.com/problems/longest-repeating-character-replacement/
public class Solution {
    // Time Complexity O(n)
    // Space Complexity O(n)
    public int characterReplacement(String s, int k) {
        int maxFreq = 0, start = 0, longestSubstring = 0;
        Map<Character, Integer> frequencies = new HashMap<>();

        for (int end = 0; end < s.length(); end++) {
            // Create a variable for the current letter to make it easier to resuse.
            char currChar = s.charAt(end);

            // Add or update the current letter's frequency.
            frequencies.put(currChar, frequencies.getOrDefault(currChar, 0) + 1);

            // Get the max freq letter (the value only) by comparing the previous max and
            // the current one.
            // This is because we only need to use the max one (no point in the others)
            maxFreq = Math.max(maxFreq, frequencies.get(currChar));

            // Get current substring to use it to calculate the number of replacements that
            // we need.
            int currSubstring = end - start + 1;
            int replacementsNeeded = currSubstring - maxFreq;

            // If we need more replacements than the ones we can do, we move the start idx
            // one to the right
            // and decrease the frequency of the character by 1.
            if (replacementsNeeded > k) {
                frequencies.put(s.charAt(start), frequencies.getOrDefault(s.charAt(start), 0) - 1);
                start++;
            }

            // We calculate the length of the curr substring in case it changes and compare
            // that to the previous longest one.
            longestSubstring = Math.max(longestSubstring, end - start + 1);
        }
        return longestSubstring;
    }
}