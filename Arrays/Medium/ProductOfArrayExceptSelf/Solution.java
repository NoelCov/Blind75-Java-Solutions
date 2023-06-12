// Question link: https://leetcode.com/problems/product-of-array-except-self/

class Solution {
    // Time Complexity O(n)
    // Space Complexity O(n)
    public int[] productExceptSelf(int[] nums) {
        // Calculate prefix multiplication
        // Prefix y0 = x0, y1 = y0 * x1, y2 = y1 * x2
        int[] res = new int[nums.length];
        res[0] = nums[0];
        for (int i = 1; i < res.length; i++) {
            res[i] = nums[i] * res[i - 1];
        }

        // Calculate the profix using the prefix
        int postfix = 1;
        for (int i = res.length - 1; i > 0; i--) {
            res[i] = postfix * res[i - 1];
            postfix *= nums[i];
        }
        res[0] = postfix;
        return res;
    }
}