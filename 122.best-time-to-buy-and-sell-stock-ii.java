/*
 * @lc app=leetcode id=122 lang=java
 *
 * [122] Best Time to Buy and Sell Stock II
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int low = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[i-1]) {
                if (prices[i-1] > low) {
                    profit += (prices[i-1] - low);
                }
                low = prices[i];
            }
        }
        return profit;
    }
}
// @lc code=end

