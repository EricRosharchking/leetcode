/*
 * @lc app=leetcode id=67 lang=java
 *
 * [67] Add Binary
 */

// @lc code=start
class Solution {

    // public String addBinary(String a, String b) {
    //     StringBuilder sb = new StringBuilder();
    //     int i = a.length() - 1, j = b.length() - 1, c = 0;
    //     while (i >= 0 || j >= 0 || c != 0) {
    //         int ii = i >= 0 ? a.charAt(i--) - '0' : 0;
    //         int jj = j >= 0 ? b.charAt(j--) - '0' : 0;
    //         c = ii + jj + c;
    //         sb.append(c % 2);
    //         c /= 2;
    //     }
    //     return sb.reverse().toString();
    // }

    public String addBinary(String a, String b) {
        String c = "";
        int k = 0;
        int i = 1, j = 1;
        for (; i <= a.length() && j <= b.length(); i++, j++) {
            c = (k + a.charAt(a.length() - i) + b.charAt(b.length() - j)) % 2 + c;
            // System.out.println(a.charAt(a.length()-i));
            // System.out.println(b.charAt(b.length()-j));
            k = (k + a.charAt(a.length() - i) + b.charAt(b.length() - j)) / 98;
            System.out.println(k);
        }
        // System.out.println(k);
        // System.out.println(c);
        while (i <= a.length()) {
            c = (a.charAt(a.length() - i) + k) % 2 + c;
            k = (a.charAt(a.length() - i++) + k) / 50;
        }
        // System.out.println(k);
        while (j <= b.length()) {
            c = (b.charAt(b.length() - j) + k) % 2 + c;
            k = (b.charAt(b.length() - j++) + k) / 50;
        }
        System.out.println(k);
        if (k == 1) {
            c = 1 + c;
        }
        return c;
    }
}
// @lc code=end
