/*
 * @lc app=leetcode id=274 lang=java
 *
 * [274] H-Index
 */

// @lc code=start
class Solution {
    public int hIndex(int[] citations) {
        int res = 0;
        int n = citations.length;
        int[] buckets = new int[n+1];
        for (int c: citations) {
            if (c >= n) {
                buckets[n]++;
            } else {
                buckets[c]++;
            }
        }
        for (int i = n; i >= 0; i--) {
            res += buckets[i];
            if (res >= i) {
                return i;
            }
        }
        return 0;
    }
}
// @lc code=end

