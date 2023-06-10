package Arrays.Medium.GroupAnagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Question link: https://leetcode.com/problems/group-anagrams/description/

// Time Complexity O(n * m) where m is the length of the string
// Space Complexity O(n * m) where N is the number of of characters a string has (since we're getting the frequency)
// and m is the number of strings that we have.
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Go through the list 1 by 1.
        // At every string, check its chars freq (saving it to a hashmap)
        // Then comparing that Map to a map/array of maps (to see if it exists)
        // Add the word if it does not exist or add it to the existing list.
        // At the end return the map values

        Map<Map<Character, Integer>, List<String>> res = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            String word = strs[i];
            Map<Character, Integer> wordFreq = getFreq(word);

            if (res.containsKey(wordFreq)) {
                List<String> list = res.get(wordFreq);
                list.add(word);
            } else {
                List<String> list = new ArrayList<>();
                list.add(word);
                res.put(wordFreq, list);
            }
        }
        return new ArrayList<>(res.values());

    }

    public Map<Character, Integer> getFreq(String word) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            map.put(word.charAt(i), map.getOrDefault(word.charAt(i), 0) + 1);
        }
        return map;
    }
}
