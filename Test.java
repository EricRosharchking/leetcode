import java.util.Arrays;

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

        Test t = new Test();
        int[][] arr = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        
        for (int[] row : arr)
        System.out.println(Arrays.toString(row));
        t.rotate(arr);
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
