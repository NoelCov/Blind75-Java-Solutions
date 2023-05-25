import java.util.*;

// This solution uses a hashmap to store the numbers that we've encountered so far.
// In case we need them in the future.

// Note: In leetcode one of the assumptions was that you will always get at least 1 result
// that's why I didn't include anything to check if the input was empty or things like that.

// Time complexity O(n)
// Space complexity O(n)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hash = new HashMap<>();
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int numNeeded = target - nums[i];
            if (hash.containsKey(numNeeded)) {
                result[0] = i;
                result[1] = hash.get(numNeeded);
                return result;
            }
            hash.put(nums[i], i);
        }
        return result;
    }
}