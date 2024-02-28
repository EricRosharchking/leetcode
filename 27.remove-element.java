/*
 * @lc app=leetcode id=27 lang=java
 *
 * [27] Remove Element
 */

// @lc code=start
class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return nums.length;
        }
        int k = 0;
        int l = nums.length - 1;
        while ( k <= l) {
            if (k < nums.length && nums[k] != val) {
                k++;
            }
            if (l >= 0 && nums[l] == val) {
                l--;
            }
            if (k < l && l >= 0 && nums[k] == val && nums[l] != val) {
                nums[k] = nums[l];
                nums[l] = val;
                k++;
                l--;
            }
        }
        if (k < nums.length && nums[k] == val) {
            return k;
        }
        return k+1;
    }
}
// @lc code=end

