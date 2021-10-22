import java.util.HashMap;

public class problem1 {
    public int[] twoSum(int[] nums, int target) {
        // brute force: O(N*N)
        // for (int i = 0; i < nums.length; i++) {
        // for (int j = i + 1; j < nums.length; j++) {
        // if (nums[i] + nums[j] == target) {
        // return new int[] {i,j};
        // }
        // }
        // }

        // better than brute force : use hashmap, choose key, value pair carefully
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(target - nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (map.keySet().contains(nums[i]) && i != map.get(nums[i])) {
                return new int[] { i, map.get(nums[i]) };
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int j = nums.length - 1;
            while (i < j) {
                if (target - nums[i] > nums[j]) {
                    break;
                } else if (target - nums[i] < nums[j]) {
                    j--;
                } else {
                    return new int[] { i, j };
                }
            }
        }

        return null;
    }

}
