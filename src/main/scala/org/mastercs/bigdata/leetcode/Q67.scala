package org.mastercs.bigdata.leetcode

/**
 *
 * @author HUAWEI
 * @date 2023/4/5 1:05
 */
object Q67 {

    def addBinary(a: String, b: String): String = {
        (BigInt.apply(a, 2) + BigInt.apply(b, 2)).toString(2)
    }
}
