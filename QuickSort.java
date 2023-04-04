import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {5,2,2,0,3,1};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    // (array to sort, left index inclusive, right index exclusive)
    public static void sort(int[] arr, int l, int r) {
        if (r - 1 < l) {
            return;
        }
        if (r - l == 1) {
            if (arr[l] > arr[r]) {
                swap(arr, l, r);
            }
            return;
        }
        int[] part = partition(arr, l, r);
        System.out.println(Arrays.toString(part));
        // System.out.println(Arrays.toString(arr));
        boolean swapLeft = false, swapRight = false;
        // int leftSwitch = -1, rightSwitch = -1;
        int i = l, j = r - 1;
        for (; i < j; ) {
            if (arr[i] > arr[r]) {
                swapLeft = true;
            } else {
                i ++;
            }
            if (arr[j] <= arr[r]) {
                swapRight = true;
            } else {
                j --;
            }

            if (swapLeft && swapRight) {
                swap(arr, i++, j--);
                swapLeft = false;
                swapRight = false;
            }
        }

        if (arr[i] > arr[r]){
            swap(arr, i, r);
        }else {
            swap(arr, i + 1, r);
        }
        // System.out.println("i: "+ i +", j: "+ j +", l: "+ l +", r: "+ r);
        sort(arr, l, i);
        sort(arr, j, r);
    }

    public static int[] partition(int[] arr, int left, int right) {
        int index = (int)(Math.random() * (right - left)) + left;
        System.out.println(index);
        swap(arr, left, index);
        int l = left, r = right;
        int pivot = arr[l];
        for (int i = l-1, j = right; i < l && j > r; i++, j--) {
            if (arr[i] == pivot) {
                swap(arr, i, --l);
            }
            if (arr[j] == pivot) {
                swap(arr, j, ++r);
            }
        }

        System.out.println(Arrays.toString(arr));
        return new int[]{l, r};
    }

    public static void swap(int[] arr, int leftSwitch, int rightSwitch) {
        int temp = arr[leftSwitch];
        arr[leftSwitch] = arr[rightSwitch];
        arr[rightSwitch] = temp;
    }
}
