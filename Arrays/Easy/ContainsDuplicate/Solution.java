import java.util.*;

// Question link: https://leetcode.com/problems/contains-duplicate/

// Time Complexity O(n)
// Space Complexity O(n)
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }

            set.add(nums[i]);
        }
        return false;
    }
}