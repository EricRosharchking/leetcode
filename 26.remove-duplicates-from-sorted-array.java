/*
 * @lc app=leetcode id=26 lang=java
 *
 * [26] Remove Duplicates from Sorted Array
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int currIndex = 0;
        int nextIndex = 0;
        while (nextIndex < nums.length) {
            if (nums[currIndex] == nums[nextIndex]) {
                nextIndex++;
            } else {
                nums[currIndex+1] = nums[nextIndex];
                currIndex++;
                nextIndex++;
            }
        }
        return currIndex+1;
    }
}
// @lc code=end

