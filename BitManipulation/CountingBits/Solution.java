// Question link: https://leetcode.com/problems/counting-bits/

// Time Complexity O(n)
// Space Complexity O(n);
class Solution {
    public int[] countBits(int n) {
        // Initialize array with size of n + 1 and add the first subProblem.
        int[] dp = new int[n + 1];
        dp[0] = 0;

        // Start offset at 1 since we only have one item in the list so far that we will
        // use to offset for the first value.
        int offset = 1;

        // Do a linear run on the array changing the value that we get from the dp
        // operation.
        for (int i = 1; i < dp.length; i++) {
            if (offset * 2 == i) {
                offset = i;
            }

            dp[i] = 1 + dp[i - offset];
        }
        return dp;
    }
}