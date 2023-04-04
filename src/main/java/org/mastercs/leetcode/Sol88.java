package org.mastercs.leetcode;

import java.util.Arrays;

public class Sol88 {

    /**
     * 先合并在排序
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0, j = m; i < n; i++) {
            nums1[j++] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    /**
     * 采用归并排序的思想，双指针实现
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int[] merged = new int[m + n];
        int l = 0, r = 0, cur = 0;
        while (l < m || r < n) {
            if (l == m) {
                merged[cur] = nums2[r];
                cur++;
                r++;
            } else if (r == n) {
                merged[cur] = nums1[l];
                cur++;
                l++;
            } else if (nums1[l] < nums2[r]) {
                merged[cur] = nums1[l];
                cur++;
                l++;
            } else {
                merged[cur] = nums2[r];
                cur++;
                r++;
            }
        }
        System.arraycopy(merged, 0, nums1, 0, merged.length);
    }

    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 0, 0, 0};
        new Sol88().merge(
                ints, 3,
                new int[]{2, 5, 6}, 3
        );
        System.out.println(Arrays.toString(ints));

        int[] ints2 = {1, 2, 3, 0, 0, 0};
        new Sol88().merge2(
                ints2, 3,
                new int[]{2, 5, 6}, 3
        );
        System.out.println(Arrays.toString(ints2));
    }
}
