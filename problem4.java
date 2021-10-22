public class problem4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] nums = new int[m+n];
        // System.out.println(Arrays.toString(nums)); 
        int i = 0, j = 0, k = 0;
        for (; i < m && j < n && k <= (m+n)/2; k ++) {
            if (nums1[i] <= nums2[j]) {
                nums[k] = nums1[i];
                i ++;
            } else {
                nums[k] = nums2[j];
                j ++;
            }
        }
        // System.out.println(Arrays.toString(nums));

        return (nums[(m+n)/2] + nums[(m+n-1)/2]) / 2.0;
    }
}
