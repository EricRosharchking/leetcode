/*
 * @lc app=leetcode id=88 lang=java
 *
 * [88] Merge Sorted Array
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        if (m == 0) {
            while ( m < n) {
                nums1[m] = nums2[m];
                m++;
            }
            return;
        }
        int i = m - 1;
        int j = n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[i+j+1] = nums1[i];
                i--;
            } else {
                nums1[i+j+1] = nums2[j];
                j--;
            }
        }
        while (j >= 0) {
            nums1[j] = nums2[j];
            j--;
        }
    }
}
// @lc code=end

