/*
 * @lc app=leetcode id=338 lang=java
 *
 * [338] Counting Bits
 */

// @lc code=start
class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        res[0] = 0;
        for (int i = 1; i <= n; i ++) {
            res[i] = (i & 1) + res[i >> 1];
        }
        return res;
    }

    /*
     * 偶数的二进制表示 与他们的一半的（偶数向右无符号位移一位）二进制
     * 表示得到的一的个数是相等的 如果n是一个奇数那么只需要在把n右移后
     * 的数字的一的位数加上1就可以得到n的二进制表示的1的个数（不断右移
     * 直到此数为1
     * 一个奇数 与 1 得 1；
     * 一个偶数 与 1 得 0；
     * 一个数右移一位等于它的一半；
     */

}
// @lc code=end
