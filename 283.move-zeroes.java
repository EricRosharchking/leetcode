/*
 * @lc app=leetcode id=283 lang=java
 *
 * [283] Move Zeroes
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length - k; i++) {
            if (nums[i] == 0) {
                for (int j = i + 1; j < nums.length - k; j++) {
                    nums[j] = nums[j - 1] ^ nums[j];
                    nums[j - 1] = nums[j - 1] ^ nums[j];
                    nums[j] = nums[j - 1] ^ nums[j];
                }
                k++;
            }
            if (nums[i] == 0) {
                i--;
            }
        }
    }

    // // Shift non-zero values as far forward as possible
    // // Fill remaining space with zeros

    // public void moveZeroes(int[] nums) {
    //     if (nums == null || nums.length == 0)
    //         return;

    //     int insertPos = 0;
    //     for (int num : nums) {
    //         if (num != 0)
    //             nums[insertPos++] = num;
    //     }

    //     while (insertPos < nums.length) {
    //         nums[insertPos++] = 0;
    //     }
    // }


    //snowball solution
    // public void moveZeroes(int[] nums) {
    //     int snowBallSize = 0; 
    //     for (int i=0;i<nums.length;i++){
	//         if (nums[i]==0){
    //             snowBallSize++; 
    //         }
    //         else if (snowBallSize > 0) {
	//             int t = nums[i];
	//             nums[i]=0;
	//             nums[i-snowBallSize]=t;
    //         } // shift only the current number and the snowball head
    //     }
    // }


        // same as snowball
    // public void moveZeroes(int[] nums) {
    //     int j = 0;
    //     for(int i = 0; i < nums.length; i++) {
    //         if(nums[i] != 0) {
    //             int temp = nums[j];
    //             nums[j] = nums[i];
    //             nums[i] = temp;
    //             j++;
    //         }
    //     }
    // }
}
// @lc code=end
