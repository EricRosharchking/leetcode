/*
 * @lc app=leetcode id=278 lang=java
 *
 * [278] First Bad Version
 */

// @lc code=start
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    // public int firstBadVersion(int n) {
    //     int start = 1, end = n;
    //     while (start < end) {
    //         int mid = start + (end-start) / 2;
    //         if (!isBadVersion(mid)) start = mid + 1;
    //         else end = mid;            
    //     }        
    //     return start;
    // }

    public int firstBadVersion(int n) {
        return firstBadVersion(1, n);
    }

    public int firstBadVersion(int i, int n) {
        if (isBadVersion(i)) {
            return i;
        }
        
        int j = (i + n) / 2;
        while ( i != n - 1) {
            if (isBadVersion(j)) {
                n = j;
            } else {
                i = j;
            }
            j = (i + n) >>> 1;
        }
        return i+1;
    }
}
// @lc code=end

