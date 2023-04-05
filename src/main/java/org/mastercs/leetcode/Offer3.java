package org.mastercs.leetcode;

/**
 * @author HUAWEI
 * @date 2023/4/5 6:16
 */
public class Offer3 {

    public int findRepeatNumber(int[] nums) {
        int[] countMap = new int[nums.length];
        for (int num : nums) {
            countMap[num]++;
        }
        for (int i = 0; i < countMap.length; i++) {
            if (countMap[i] > 1) {
                return i;
            }
        }
        return -1;
    }
}
