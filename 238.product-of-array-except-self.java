/*
 * @lc app=leetcode id=238 lang=java
 *
 * [238] Product of Array Except Self
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                res[i] = -1;
                zeroCount++;
            }
        }
        if (zeroCount == 2) {
            return new int[nums.length];
        }
        int num = 1;
        if (zeroCount == 1) {
            for (int i = 0; i < nums.length; i++) {
                if (res[i] == -1) {
                    continue;
                }
                num *= nums[i];
            }
            for (int i = 0; i < nums.length; i++) {
                if (res[i] == -1) {
                    res[i] = num;
                    return res;
                }
            }
        }
        int n = nums.length;
        int[] prefix = new int[n];
        int[] sufix = new int[n];
        prefix[0] = 1;
        sufix[n-1] = 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i-1] * nums [i-1];
        }
        for (int i = n-1; i > 0; i--) {
            sufix[i-1] = sufix[i] * nums[i];
        }
        for (int i = 0; i < n; i++) {
            res[i] = prefix[i] * sufix[i];
        }
        System.out.println(Arrays.toString(prefix));
        System.out.println(Arrays.toString(sufix));
        return res;
    }
}
// @lc code=end

