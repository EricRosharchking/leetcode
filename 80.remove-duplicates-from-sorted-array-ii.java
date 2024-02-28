/*
 * @lc app=leetcode id=80 lang=java
 *
 * [80] Remove Duplicates from Sorted Array II
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 3) {
            return nums.length;
        }
        int currIndex = 0;
        // currNumber, 1 or 2 occur
        // nextNumber, multiple occur
        int removed = 0;
        int nextIndex = 0;
        while (nextIndex < nums.length) {
            if (nextIndex < nums.length && nums[currIndex] == nums[nextIndex]) {
                nextIndex++;
            } else {
                if (nextIndex < nums.length) {
                    int tmpIndex = nextIndex;
                    while (tmpIndex < nums.length && nums[tmpIndex] == nums[nextIndex]) {
                        tmpIndex++;
                    }
                    if (nextIndex - currIndex > 2 + removed) {
                        nums[currIndex + 1] = nums[currIndex];
                        nums[currIndex + 2 + removed] = nums[nextIndex];
                        removed += (nextIndex - currIndex - 2);
                        currIndex += 2;
                    } else {
                        nums[currIndex + 1] = nums[nextIndex];
                        currIndex += 1;
                    }
                    nextIndex = tmpIndex;
                }
            }
        }
        return nums.length - removed;
    }
}
// @lc code=end
