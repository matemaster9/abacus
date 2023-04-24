package org.mastercs.bigdata_scala.leetcode

/**
 *
 * @author HUAWEI
 * @date 2023/4/5 2:25
 */
object Q169 {

    def majorityElement(nums: Array[Int]): Int = {
        nums.sorted.drop(nums.length / 2).head
    }

    def main(args: Array[String]): Unit = {
        val sortedArr = Array(3, 2, 3).sorted
        println(sortedArr.mkString("Array(", ", ", ")"))
        println(sortedArr.drop(sortedArr.length / 2).mkString("Array(", ", ", ")"))
    }
}
