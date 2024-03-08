/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        int water = 0;
        int peak = 0;
        int peakIndex = 0;
        for (int i = 0; i < height.length; i++) {
            if (peak < height[i]) {
                peakIndex = i;
                peak = height[i];
            }
        }
        int rightBankIndex = peakIndex;
        int leftBankIndex = peakIndex;
        while (rightBankIndex >= 0) {
            int bank = 0;
            int bankIndex = rightBankIndex - 1;
            for (int i = 0; i < rightBankIndex; i++) {
                if (bank < height[i]) {
                    bank = height[i];
                    bankIndex = i;
                }
            }
            
            for (int i = bankIndex; i <= rightBankIndex && i >= 0; i++) {
                if (bank >= height[i]) {
                    water += (bank - height[i]);
                }
            }
            rightBankIndex = bankIndex - 1;
        }

        while (leftBankIndex < height.length) {
            int bank = 0;
            int bankIndex = height.length - 1;
            for (int i = bankIndex; i > leftBankIndex; i--) {
                if (bank < height[i]) {
                    bank = height[i];
                    bankIndex = i;
                }
            }
            for (int i = bankIndex; i >= leftBankIndex && i < height.length; i--) {
                if (bank >= height[i]) {
                    water += (bank - height[i]);
                }
            }
            leftBankIndex = bankIndex + 1;
        }
        return water;


        
        // int leftMax = 0;
        // int rightMax = 0;
        // int left = 0;
        // int right = height.length - 1;
        // int ans = 0;
        // while (left<right) {
        //     if (height[left] < height[right]) {
        //         if (height[left] >= leftMax) {
        //             leftMax = height[left];
        //         } else {
        //             ans += leftMax - height[left];
        //         }
        //         left++;
        //     } else {
        //         if (height[right] >= rightMax) {
        //             rightMax = height[right];
        //         } else {
        //             ans += rightMax - height[right];
        //         } 
        //         right--;
        //     }
        // }
        // return ans;
    }
}
// @lc code=end

