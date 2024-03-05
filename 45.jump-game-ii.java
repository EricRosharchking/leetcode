/*
 * @lc app=leetcode id=45 lang=java
 *
 * [45] Jump Game II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        int[] steps = new int[nums.length];
        steps[0] = 0;
        for (int i = 1; i < steps.length; i++) {
            steps[i] = -1;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <= nums[i] ; j++) {
                if (i+j < nums.length && steps[i+j] == -1) {
                    steps[i+j] = steps[i] + 1;
                }
            }
        }
        return steps[nums.length-1];
    }
}
// @lc code=end

