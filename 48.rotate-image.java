/*
 * @lc app=leetcode id=48 lang=java
 *
 * [48] Rotate Image
 */

// @lc code=start
class Solution {
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        for (int i = 0; i < length/2; i++) {
            for (int j = 0; j < length / 2; j ++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[length-i][j];
                matrix[length-i][j] = matrix[length-i][length-j];
                matrix[length-i][length-j] = matrix[i][length-j];
                matrix[i][length-j] = tmp;
            }
        }

        System.out.println(matrix);
    }
}
// @lc code=end

