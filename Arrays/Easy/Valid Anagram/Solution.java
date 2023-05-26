import java.util.*;

// Question link: https://leetcode.com/problems/valid-anagram/

// Time Complexity O(n + m) n = s, m = t
// Space Complexity O(n) n = s.length
class Solution {
    // 1 SOLUTION:
    // 1. Go through one, save the letters and their frequency in a hashmap
    // 2. Go through second one, if a letter doesn't exist in the hashmap return
    // false
    // If it does exist, decrease it by 1 (if 0 then delete that property)
    // 3. Check if the hashmap is empty, it should be if the two strings are
    // anagrams.
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            if (freq.containsKey(letter)) {
                int frequency = freq.get(letter);
                freq.replace(letter, ++frequency);
            } else {
                freq.put(letter, 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            char letter = t.charAt(i);
            if (!freq.containsKey(letter)) {
                return false;
            } else {
                int frequency = freq.get(letter);
                if (frequency == 1) {
                    freq.remove(letter);
                } else {
                    freq.replace(letter, --frequency);
                }
            }
        }
        return freq.isEmpty();
    }
}
