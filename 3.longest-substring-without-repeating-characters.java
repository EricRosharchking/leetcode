import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                j = j > map.get(s.charAt(i)) + 1 ? j : map.get(s.charAt(i)) + 1;
            }
            res = (i - j + 1) > res ? i - j + 1 : res;
            map.put(s.charAt(i), i);
        }
        return res;
    }

    // public int lengthOfLongestSubstring(String s) {
    //     int result = 0;
    //     int[] cache = new int[256];
    //     for (int i = 0, j = 0; i < s.length(); i++) {
    //         j = (cache[s.charAt(i)] > 0) ? Math.max(j, cache[s.charAt(i)]) : j;
    //         cache[s.charAt(i)] = i + 1;
    //         result = Math.max(result, i - j + 1);
    //     }
    //     return result;
    // }
}
// @lc code=end
