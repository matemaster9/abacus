package org.mastercs.bigdata_scala

import org.mastercs.bigdata_scala.leetcode.Q58
import org.scalatest.funsuite.AnyFunSuite

/**
 *
 * @author HUAWEI
 * @date 2023/4/5 0:44
 */
class LeetCode extends AnyFunSuite {

    test("58. 最后一个单词的长度") {
        println(Q58.lengthOfLastWord("scala lang"))
    }

    test("2427") {
        val x = 100
        val m = 24
        println((1 to 24).count(i => x % i == 0 && m % i == 0))
    }
}
