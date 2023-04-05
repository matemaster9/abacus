package org.mastercs.leetcode;

/**
 * @author HUAWEI
 * @date 2023/4/5 6:25
 */
public class Sol2427 {

    public int commonFactors(int a, int b) {
        int small = Math.min(a, b);
        int count = 0;
        for (int i = 1; i <= small; i++) {
            if ((a %i == 0) && (b % i == 0) ){
                count++;
            }
        }
        return count;
    }
}
