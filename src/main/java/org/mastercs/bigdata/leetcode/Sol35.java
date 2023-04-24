package org.mastercs.bigdata.leetcode;

import java.util.Arrays;

public class Sol35 {

    @Deprecated
    public int searchInsert(int[] nums, int target) {
        int i = Arrays.binarySearch(nums, target);
        if (Arrays.binarySearch(nums, target) > 0) {
            return i;
        }
        int[] arr = Arrays.copyOf(nums, nums.length + 1);
        arr[arr.length - 1] = target;
        Arrays.sort(arr);
        return Arrays.binarySearch(arr, target);
    }

    public int searchInsert2(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = ((r - l) >> 1) + l;
            if (target <= nums[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        System.out.println(new Sol35().searchInsert(new int[]{1, 2, 3, 4, 5}, 3));
        System.out.println(new Sol35().searchInsert(new int[]{1, 2, 4, 5}, 3));
        System.out.println(new Sol35().searchInsert(new int[]{1, 2, 3, 3, 3, 4, 5}, 3));
        System.out.println(new Sol35().searchInsert2(new int[]{1, 2, 3, 3, 3, 4, 5}, 3));
    }
}
