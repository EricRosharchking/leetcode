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
        int prevIndex = -1;
        int currIndex = 0;
        // currNumber, 1 or 2 occur
        // nextNumber, multiple occur
        int removed = 0;
        int nextIndex = 0;
        while (currIndex < nums.length) {
            while (nextIndex < nums.length && nums[currIndex] == nums[nextIndex]) {
                nextIndex++;
            }
            if (nextIndex - currIndex == 1) {
                nums[prevIndex+1] = nums[currIndex];
                prevIndex += 1;
            } else if (nextIndex - currIndex == 2) {
                nums[prevIndex+1] = nums[currIndex];
                nums[prevIndex+2] = nums[currIndex];
                prevIndex += 2;
            }
            if (nextIndex - currIndex > 2) {
                removed += (nextIndex - currIndex -2);
                nums[prevIndex+1] = nums[currIndex];
                nums[prevIndex+2] = nums[currIndex];
                prevIndex += 2;
            }
            currIndex = nextIndex;
        }
        return nums.length - removed;
    }
}
// @lc code=end
