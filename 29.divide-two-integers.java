/*
 * @lc app=leetcode id=29 lang=java
 *
 * [29] Divide Two Integers
 */

// @lc code=start
class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == 1 << 31 && divisor == -1)
            return (1 << 31) - 1;
        int a = Math.abs(dividend), b = Math.abs(divisor), res = 0;
        for (int x = 31; x >= 0; x--)
            if ((a >>> x) - b >= 0) {
                res += 1 << x;
                a -= b << x;
            }
        return (dividend > 0) == (divisor > 0) ? res : -res;
    }

    // public int divide(int dividend, int divisor) {
    //     if (divisor == 1) {
    //         return dividend;
    //     } else if (divisor == -1) {
    //         if (dividend > Integer.MAX_VALUE || dividend <= Integer.MIN_VALUE)
    //             return Integer.MAX_VALUE;
    //         return -dividend;
    //     } else {
    //         int a = dividend;
    //         int b = divisor;
    //         if (a < 0) {
    //             a = -a;
    //         }
    //         if (b < 0) {
    //             b = -b;
    //         }
    //         System.out.println(a);
    //         System.out.println(b);
    //         if (a < b) {
    //             return 0;
    //         } else {
    //             int i = 0;
    //             while (!(a < b)) {
    //                 a = a - b;
    //                 i++;
    //             }
    //             if (dividend < 0)
    //                 i = -i;
    //             if (divisor < 0)
    //                 i = -i;
    //             if (i > Integer.MAX_VALUE || i < Integer.MIN_VALUE)
    //                 return Integer.MAX_VALUE;
    //             return i;
    //         }
    //     }
    // }

}

// @lc code=end
