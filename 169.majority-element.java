/*
 * @lc app=leetcode id=169 lang=java
 *
 * [169] Majority Element
 */

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        if (nums.length < 2) {
            return nums[0];
        }
        int[] tmp = new int[nums.length];
        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length && tmp[j] != -1; j++){
                if (nums[j] == nums[i]) {
                    res++;
                    tmp[j] = -1;
                }
            }
            tmp[i] = res;
        }
        for (int i = 0; i < tmp.length; i++) {
            if(tmp[i] > nums.length/2) {
                return nums[i];
            }
        }
        return res;
    }
}
// @lc code=end

