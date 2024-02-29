/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int high = 0;
        int low = 0;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < prices[low]) {
                low = i;
                high = low;
            }
            if (prices[i] > prices[high]) {
                high = i;
            }
            if (high > low) {
                if (prices[high] - prices[low] > profit) {
                    profit = prices[high] - prices[low];
                }
            }
        }
        return profit;
    }
}
// @lc code=end
