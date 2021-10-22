/*
 * @lc app=leetcode id=977 lang=java
 *
 * [977] Squares of a Sorted Array
 */

// @lc code=start
class Solution {
    public int[] sortedSquares(int[] nums) {
                
        int[] res = new int[nums.length];
        for (int i = 0, j = nums.length - 1, k = 0; i <= j; k++) {
            if (nums[i] * nums[i] <= nums[j]* nums[j]) {
                res[res.length - 1 - k] = nums[j] * nums[j];
                j--;
            } else {
                res[res.length - 1 - k] = nums[i] * nums[i];
                i++;
            }
        }
        return res;
    }
}
// @lc code=end

