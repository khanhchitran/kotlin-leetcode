package problems;

import java.util.Arrays;

/**
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 */
public class RotateArray189 {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int r = k % n;
        if(r == 0 || k == 0){
            System.out.println(Arrays.toString(nums));
            return;
        }
        int[] left = Arrays.copyOfRange(nums,n-r,n);
        int[] right = Arrays.copyOfRange(nums,0,n-r);

        System.arraycopy(left, 0, nums, 0, left.length);
        System.arraycopy(right, 0, nums, left.length, right.length);
        System.out.println(Arrays.toString(nums));
    }
}
//public class RotateArray189_2 {
//    public void rotate(int[] nums, int k){
//          int n = nums.length;
//          int r = k % n;
//          reverse(nums,0, n - 1);
//          reverse(nums, 0, r - 1);
//          reverse(nums, r, n - 1);
//          System.out.println(Arrays.toString(nums));
//
//    }
//    private void reverse(int[] nums, int start, int end){
//        while(start < end){
//            int temp = nums[start];
//            nums[start] = nums[end];
//            nums[end] = temp;
//            start++;
//            end--;
//        }
//    }
//}
