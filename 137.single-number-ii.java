/*
 * @lc app=leetcode id=137 lang=java
 *
 * [137] Single Number II
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            int cnt = 0;
            for (int num : nums) {
                cnt += num >> i & 1;
            }
            if (cnt % 3 != 0) {
                ret |= 1 << i; // 神来之笔
            }
        }
        return ret;
    }

    // int res = 0;
    // for (int i = 0; i < 32; i ++) {
    //     int bit = 0;
    //     for (int num: nums) {
    //         bit += (num >>> i) & 1;
    //     }
    //     res += (bit % 3) << i;
    // }
    // return res;
}
// @lc code=end
