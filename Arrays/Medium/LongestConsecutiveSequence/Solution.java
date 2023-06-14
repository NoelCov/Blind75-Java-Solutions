package Arrays.Medium.LongestConsecutiveSequence;

import java.util.*;

// Question link: https://leetcode.com/problems/longest-consecutive-sequence/

class Solution {
    // Time Complexity O(n)
    // Space Complexity O(n)
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int maxSequence = 0;
        int currSequence = 0;
        for (Integer num : set) {
            if (!set.contains(num - 1) && set.contains(num + 1)) {
                int currNum = num;
                while (set.contains(currNum + 1)) {
                    currNum += 1;
                    currSequence += 1;
                }
                maxSequence = Math.max(maxSequence, currSequence);
                currSequence = 0;
            }
        }

        // We add 1 because we never counter the first number that
        // started the sequence. Also, in the event that there not sequence longer than
        // one number alone, the result would be 0 so we add 1 to account for that.
        maxSequence = Math.max(maxSequence, currSequence) + 1;
        return maxSequence;
    }
}