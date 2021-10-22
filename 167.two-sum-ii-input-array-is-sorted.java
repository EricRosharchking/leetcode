/*
 * @lc app=leetcode id=167 lang=java
 *
 * [167] Two Sum II - Input array is sorted
 */

// @lc code=start
class Solution {

    //O(N*log(N))
    public int[] twoSum(int[] numbers, int target) {
        // two pointers with binary search
        for (int i = 0; i < numbers.length; i++) {
            int j = i + 1;
            int k = numbers.length;
            int mid = j + (k - j - 1) / 2;
            int a = target - numbers[i];
            while (j <= k && mid < numbers.length) {
                if (numbers[mid] == a) {
                    return new int[] { i + 1, mid + 1 };
                } else if (numbers[mid] < a) {
                    j = mid + 1;
                } else if (numbers[mid] > a) {
                    k = mid - 1;
                }
                mid = j + (k - j - 1) / 2;
            }
        }
        return null;
    }

    // O(N)
    // public int[] twoSum(int[] numbers, int target) {
    //     int start = 0, end = numbers.length - 1;
    //     while (start < end) {
    //         if (numbers[start] + numbers[end] == target)
    //             break;
    //         if (numbers[start] + numbers[end] < target)
    //             start++;
    //         else
    //             end--;
    //     }
    //     return new int[] { start + 1, end + 1 };
    // }
}
// @lc code=end
