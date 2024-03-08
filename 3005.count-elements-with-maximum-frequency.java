/*
 * @lc app=leetcode id=3005 lang=java
 *
 * [3005] Squares of a Sorted Array
 */

// @lc code=start
class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] arr = new int[101];
        for (int i: nums) {
            arr[i]++;
        }
        int frequency = 0;
        for (int i: arr) {
            if (i > frequency) {
                frequency = i;
            }
        }
        int res = 0;
        for (int i: arr) {
            if (i == frequency) {
                res += i;
            }
        }
        return res;
    }
}
// @lc code=end

