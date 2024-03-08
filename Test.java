import java.util.Arrays;
import java.util.Collections;

public class Test {

    public static void main(String[] args) {
        /*
         * problem 3 problem3 p3 = new problem3();
         * System.out.println(p3.lengthOfLongestSubstring("abba"));
         */

        /*
         * problem 4
         */
        // problem4 p = new problem4();
        // System.out.println(p.findMedianSortedArraysBrute(new int[] {1,2}, new int[]
        // {3,4,5,6}));
        // System.out.println(Integer.MIN_VALUE);
        // System.out.println(Integer.MIN_VALUE - 50000);
        // System.out.println(addBinary("110010", "10111"));
        // int i = 1;
        // System.out.println((--i) == 0);

        // Test t = new Test();
        // int[][] arr = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14,
        // 15, 16 } };

        // for (int[] row : arr)
        // System.out.println(Arrays.toString(row));
        // t.rotate(arr);
        int[][] nums = { { 0,1,0,2,1,0,1,3,2,1,2,1},{4,2,0,3,2,5} };
        for (int[] arr : nums) {
            System.out.println(Arrays.toString(arr));
        }
        System.out.println(trap(nums[0]));
    }

    public static int trap(int[] height) {
        int water = 0;
        int peak = 0;
        int peakIndex = 0;
        for (int i = 0; i < height.length; i++) {
            if (peak < height[i]) {
                peakIndex = i;
                peak = height[i];
            }
        }
        System.out.println("Peak is " + peak + ", at index " + peakIndex);
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
            System.out.println("Bank is " + bank + ", LeftBank at index " + bankIndex + " RightBank at index " + rightBankIndex);
            for (int i = bankIndex; i <= rightBankIndex && i >= 0; i++) {
                if (bank >= height[i]) {
                System.out.println("Tapping " + (bank - height[i]) + " water at " + i + " position");
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
            System.out.println("Bank is " + bank + ", leftBank at index " + leftBankIndex + " RightBank at index " + bankIndex);
            for (int i = bankIndex; i >= leftBankIndex && i < height.length; i--) {
                if (bank >= height[i]) {
                System.out.println("Tapping " + (bank - height[i]) + " water at " + i + " position");
                water += (bank - height[i]);
                }
            }
            leftBankIndex = bankIndex + 1;
        }
        return water;
    }
    
    public static int[] solution(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int[] prefix = new int[n];
        int[] sufix = new int[n];
        prefix[0] = 1;
        sufix[n-1] = 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i-1] * nums [i-1];
        }
        for (int i = n-1; i > 0; i--) {
            sufix[i-1] = sufix[i] * nums[i];
        }
        for (int i = 0; i < n; i++) {
            res[i] = prefix[i] * sufix[i];
        }
        System.out.println(Arrays.toString(prefix));
        System.out.println(Arrays.toString(sufix));
        return res;
    }

    public static int minOperationsToWriteY_3071(int[][] grid) {
        int n = grid.length;
        int[] nums_y = new int[3];
        int[] nums = new int[3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = grid[i][j];
                if (i < n / 2) {
                    if (j == i || j + i == n-1) {
                        nums_y[num]++;
                    } else {
                        nums[num]++;
                    }
                } else if ( j == n/2) {
                    nums_y[num]++;
                } else {
                    nums[num]++;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(nums_y));
        int res = n * n;
        int a = n + n / 2;
        int b = res - a;
        for (int i = 0; i < 3; i++) {
            int y = a - nums_y[i];
            int others = 0;
            if (i == 0) {
                others = Math.min(b-nums[1], b-nums[2]);
            }
            if (i == 1) {
                others = Math.min(b-nums[0], b-nums[2]);
            }
            if (i == 2) {
                others = Math.min(b-nums[0], b-nums[1]);
            }
            System.out.println(y + "," + others);
            res = Math.min(y+others, res);
            
        }
        return res;
    }

    public static int countSubmitrices_3070(int[][] grid, int k) {
        int sum = 0;
        int res = 0;
        int[][] matrix = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            sum = 0;
            for (int j = 0; j < grid[i].length; j++) {
                sum += grid[i][j];
                matrix[i][j] = sum;
            }
        }
        sum = 0;
        for (int i = 1; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                matrix[i][j] += matrix[i-1][j];
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (matrix[i][j] > k) {
                    break;
                }
                res++;
            }
        }
        return res;
    }

    public static int[] distributeElements_3069(int[] nums) {
        int n = nums.length;
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        int x = 0;
        int y = 0;
        arr1[x] = nums[0];
        arr2[y] = nums[1];
        for (int i = 2; i < n; i++) {
            if (arr1[x] > arr2[y]) {
                arr1[++x] = nums[i];
            } else {
                arr2[++y] = nums[i];
            }
        }
        System.out.println("x: " + x + "," + Arrays.toString(arr1));
        System.out.println("y: " + y + "," + Arrays.toString(arr2));
        for (int i = 0; i < y + 1; i++) {
            arr1[x + 1 + i] = arr2[i];
        }
        return arr1;
    }

    public static String addBinary(String a, String b) {
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

    public void rotate(int[][] matrix) {
        int length = matrix.length - 1;
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = 0; j <= matrix.length / 2; j++) {
                System.out.println("i:" + i + ",j:" + j);
                int tmp = matrix[i][j];
                if (i == 0) {
                    matrix[i][j] = matrix[length - i][j];
                    matrix[length - i][j] = matrix[length - i][length - j];
                    matrix[length - i][length - j] = matrix[i][length - j];
                    matrix[i][length - j] = tmp;
                } else {
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = matrix[length - i][j];
                    matrix[length - i][j] = matrix[j][length - i];
                    matrix[j][length - i] = tmp;
                }
                for (int[] arr : matrix)
                    System.out.println(Arrays.toString(arr));
            }

        }

    }

}
