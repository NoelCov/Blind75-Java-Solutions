import java.util.*;

// Question link: https://leetcode.com/problems/valid-parentheses/

// Time Complexity O(n)
// Space Complexity O(n)
class Solution {
    public boolean isValid(String s) {
        // We need to store all open brackets
        // Every time we encounter a close bracket we check if the top one is its pair
        // if so, we delete the top most item in the stack and continue
        // Otherwise return false
        // If stack is emtpy at the end of the string we then return true, otherwise
        // false.
        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == '{' || curr == '[' || curr == '(') {
                stack.add(curr);
            } else if (stack.empty() || map.get(curr) != stack.pop()) {
                return false;
            }
        }
        return stack.empty();
    }
}
