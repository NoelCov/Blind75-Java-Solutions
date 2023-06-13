// Question link: https://www.lintcode.com/problem/659/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /*
     * @param strs: a list of strings
     * 
     * @return: encodes a list of strings to a single string.
     */

    // Time O(n)
    // Space O(n)
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        String code = "!!!";

        // O(n) time and space
        for (int i = 0; i < strs.size(); i++) {
            String word = strs.get(i);
            sb.append(word);
            if (i < strs.size() - 1) {
                sb.append(code);
            }
        }
        return sb.toString();
        // Result will be: "lfirstwordcodesecondwordcodethirdword";
    }

    /*
     * @param str: A string
     * 
     * @return: dcodes a single string to a list of strings
     */
    // O(n) time and space
    public List<String> decode(String str) {
        String code = "!!!";
        List<String> res = new ArrayList<>();

        // We can go char by char, making it a string until the code,
        // we then skip the code (if it's full ofc) and add that string to the list
        // We continue until we're done.

        // Maybe if we use the split function we can but I need to check if we can give
        // it a string (we can)
        // not sure if the code has an effect but it didn't work with "!!?" I think it's
        // the way split is implemented (I can always do it manually)
        String[] strs = str.split(code);
        return Arrays.asList(strs);
    }
}