import java.util.*;

// Question link https://leetcode.com/problems/3sum/

class Solution {
    // Time Complexity O(n log n)
    // Space Complexity O(n)
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            // To avoid the same number that we previously did.
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(List.of(nums[i], nums[left], nums[right]));

                    // Move left until we find a number that is different to the one we just used.
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    // Move right until we find a number that is different to the one we just used.
                    while (right > left && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    // Move one more otherwise we end up at the exact same numgber the last one it
                    // appears consecutively.
                    left++;
                    right--;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return res;
    }
}