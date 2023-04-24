package org.mastercs.bigdata_scala.leetcode

import scala.collection.mutable

/**
 *
 * @author HUAWEI
 * @date 2023/4/5 5:03
 */
object Q381 {

    def firstUniqChar(s: String): Int = {
        var map = new mutable.HashMap[Char, Int]()
        val arr = s.toCharArray
        arr.foreach(ch => map.put(ch, map.getOrElse(ch, 0) + 1))
        for (i <- arr.indices) {
            if (map(arr(i)) == 1) {
                return i
            }
        }
        -1
    }

    def main(args: Array[String]): Unit = {
        println(Q381.firstUniqChar("leetcode"))
    }
}
