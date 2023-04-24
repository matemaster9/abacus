package org.mastercs.bigdata_scala.leetcode

/**
 *
 * @author HUAWEI
 * @date 2023/4/5 0:42
 */
object Q58 {

    def lengthOfLastWord(s: String): Int = {
        s.split(" ").last.length
    }

    def lengthOfLastWord2(s: String): Int = {
        s.length - s.lastIndexOf(" ") + 1
    }
}
