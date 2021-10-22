/*
 * @lc app=leetcode id=704 lang=java
 *
 * [704] Binary Search
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        if (nums[0] > target || nums[nums.length-1] < target)
            return -1;
        return search(nums, target, 0, nums.length - 1);
    }

    public int search(int[] nums, int target, int startIndex, int endIndex) {
        while (startIndex != endIndex) {
            int i = (startIndex + endIndex) / 2;
            if (nums[i] < target) {
                startIndex = i + 1;
            } else if (nums[i] > target) {
                endIndex = i - 1;
            } else {
                return i;
            }
        }
        return nums[startIndex] == target ? startIndex : -1;
    }

    // public int search(int[] nums, int target) {
    //     if (nums == null || nums.length == 0) return -1;
    //     int left = 0;
    //     int right = nums.length - 1;
    //     while (left <= right) {
    //         int mid = left + (right - left) / 2;
    //         if (nums[mid] == target) return mid;
    //         if (nums[mid] > target) right = mid - 1;
    //         else left = mid + 1;
    //     }
    //     return -1;
    // }
}
// @lc code=end
