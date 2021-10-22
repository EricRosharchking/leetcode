import java.util.Arrays;

/*
 * @lc app=leetcode id=567 lang=java
 *
 * [567] Permutation in String
 */

// @lc code=start
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] occ = new int[26];
        // System.out.println(Arrays.toString(occ));
        for (char c : s1.toCharArray()) {
            occ[c - 'a']++;
        }
        // System.out.println(Arrays.toString(occ));
        for (int i = 0; i <= s2.length() - s1.length();) {
            int j = 1;
            int[] tmp = occ.clone();
            int match = 0;
            // System.out.println(Arrays.toString(tmp));
            // System.out.println("i:"+i);
            for (; j <= s1.length(); j++) {
                if (--tmp[s2.charAt(i + j - 1) - 'a'] < 0) {
                    break;
                } else {
                    match++;
                }
            }
            // System.out.println(Arrays.toString(tmp));
            if (j == s1.length() + 1) {
                return true;
            }
            i = i + j - match;
            // if (match) {
            // if (j > 1) {
            // i += --j;
            // } else {
            // i ++;
            // }
            // } else {
            // i ++;
            // }
        }
        return false;
    }

    // public boolean checkInclusion(String s1, String s2) {
    //     int len1 = s1.length(), len2 = s2.length();
    //     if (len1 > len2)
    //         return false;

    //     int[] count = new int[26];
    //     for (int i = 0; i < len1; i++) {
    //         count[s1.charAt(i) - 'a']++;
    //     }

    //     for (int i = 0; i < len2; i++) {
    //         count[s2.charAt(i) - 'a']--;
    //         if (i - len1 >= 0)
    //             count[s2.charAt(i - len1) - 'a']++;
    //         if (allZero(count))
    //             return true;
    //     }

    //     return false;
    // }

    // private boolean allZero(int[] count) {
    //     for (int i = 0; i < 26; i++) {
    //         if (count[i] != 0)
    //             return false;
    //     }
    //     return true;
    // }
}
// @lc code=end
