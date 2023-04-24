package org.mastercs.bigdata.leetcode;

public class Sol27 {

    /**
     * 双指针实现
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int l = 0, r = 0;
        while (r < nums.length) {
            if (nums[r] != val) {
                nums[l] = nums[r];
                l++;
            }
            r++;
        }
        return l;
    }
}
