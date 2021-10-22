/*
 * @lc app=leetcode id=344 lang=java
 *
 * [344] Reverse String
 */

// @lc code=start
class Solution {
    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i ++) {
            char c = s[s.length - 1 - i];
            s[s.length - 1 - i] = s[i];
            s[i] = c;
        }
    }
}
// @lc code=end

