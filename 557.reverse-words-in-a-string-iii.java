/*
 * @lc app=leetcode id=557 lang=java
 *
 * [557] Reverse Words in a String III
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        String[] strings = s.split(" ");
        for (String str: strings) {
            StringBuilder sb = new StringBuilder(str);
            res.append(sb.reverse());
            res.append(" ");
        }
        return res.toString().trim();
    }
}
// @lc code=end

