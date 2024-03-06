/*
 * @lc app=leetcode id=134 lang=java
 *
 * [134] Gas Station
 */

// @lc code=start
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalCost = 0;
        int totalGas = 0;
        int partialCost = 0;
        int partialGas = 0;
        int res = 0;
        for(int i = 0; i < gas.length; i++) {
            totalCost += cost[i];
            totalGas += gas[i];
            partialCost += cost[i];
            partialGas += gas[i];
            if (partialCost > partialGas) {
                res = i + 1;
                partialCost = 0;
                partialGas = 0;
            }
        }
        if (totalCost > totalGas) {
            return -1;
        }
        return res;
    }
}
// @lc code=end