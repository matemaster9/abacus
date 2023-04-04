package org.mastercs.leetcode;

/**
 * @author HUAWEI
 * @date 2023/4/5 0:56
 */
public class Sol67 {

    public String addBinary(String a, String b) {
        long x = Long.parseLong(a, 2);
        long y = Long.parseLong(b, 2);
        return Long.toBinaryString(x + y);
    }
}
