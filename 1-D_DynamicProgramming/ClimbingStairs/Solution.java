// Question link: https://leetcode.com/problems/climbing-stairs/

// Time Complexity O(n)
// Space Complexity O(n)
class Solution {
    Map<Integer, Integer> memo = new HashMap<>();

    public int climbStairs(int n) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        if (n == 0 || n == 1) {
            return 1;
        }

        int res = climbStairs(n - 2) + climbStairs(n - 1);
        if (!memo.containsKey(n)) {
            memo.put(n, res);
        }
        return res;
    }
}