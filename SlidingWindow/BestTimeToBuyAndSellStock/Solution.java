// Question link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

// Time Complexity O(n)
// Space Complexity(1)
class Solution {
    public int maxProfit(int[] prices) {
        int currStock = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            int currProfit = prices[i] - currStock;
            if (currProfit <= 0) {
                currStock = prices[i];
            }
            maxProfit = Math.max(currProfit, maxProfit);
        }
        return maxProfit;
    }
}