import java.util.Arrays;
import java.util.stream.IntStream;

/*
 * @lc app=leetcode id=189 lang=java
 *
 * [189] Rotate Array
 */

// @lc code=start
class Solution {
    public void rotate(int[] nums, int k) {
        //have the array duplicated and put together with itself
        //and cut from the K th position of a length nums.length
        k = k - k/nums.length * nums.length;
        int[] newArr = IntStream.concat(Arrays.stream(nums), Arrays.stream(nums)).toArray();
        for (int i = 0; i < nums.length; i ++) {
            nums[i] = newArr[newArr.length - nums.length - k + i];
        }

        //iterate and put the numbers at their new position of a new array
        //which means to shift 1 position k times
        // while(k-->0){
        //     int tmp = nums[nums.length-1];
        //     for(int i = nums.length-1; i>0; i--){
        //         nums[i] = nums[i-1];
        //     }
        //     nums[0] = tmp; 
        // }


        //reverse the first arr.leng - K the elements, reverse the rest of the array
        //then reverse the entire array
        // k = k - k/nums.length * nums.length;
        // int l = nums.length;
        // for (int i = 0; i < (l - k)/2; i ++) {
        //     nums[i] = nums[i] ^ nums[l - k - 1 - i];
        //     nums[l - k - 1 - i] = nums[i] ^ nums[l - k - 1 - i];
        //     nums[i] = nums[i] ^ nums[l - k - 1 - i];
        // }
        // for (int i = l - k; i < l - k + k / 2; i ++) {
        //     nums[i] = nums[i] ^ nums[l + l - k - i - 1];
        //     nums[l + l - k - i - 1] = nums[i] ^ nums[l + l - k - i - 1];
        //     nums[i] = nums[i] ^ nums[l + l - k - i - 1];
        // }
        // for (int i = 0; i < l / 2; i ++) {
        //     nums[i] = nums[i] ^ nums[l - 1 - i];
        //     nums[l - 1 - i] = nums[i] ^ nums[l - 1 - i];
        //     nums[i] = nums[i] ^ nums[l - 1 - i];
        // }
    }
}
// @lc code=end
