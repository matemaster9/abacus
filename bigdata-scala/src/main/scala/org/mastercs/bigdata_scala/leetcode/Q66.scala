package org.mastercs.bigdata_scala.leetcode

/**
 *
 * @author HUAWEI
 * @date 2023/4/5 1:43
 */
object Q66 {

    def plusOne(digits: Array[Int]): Array[Int] = {
        (BigInt(digits.mkString) + 1).toString.map(char => char.toString.toInt).toArray
    }
}
