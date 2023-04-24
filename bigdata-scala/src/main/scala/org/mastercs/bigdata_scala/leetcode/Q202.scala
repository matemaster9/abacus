package org.mastercs.bigdata_scala.leetcode

/**
 *
 * @author HUAWEI
 * @date 2023/4/5 1:45
 */
object Q202 {

    def isHappy(n: Int): Boolean = {

        false
    }

    private def splitNumber(arg: String): Int = {
        val array = arg.toCharArray.map(char => char.toString.toInt)
        var squareSum = 0;
        array.foreach(elem => squareSum += elem * elem)
        squareSum
    }

    def main(args: Array[String]): Unit = {
        println(splitNumber("19"))
    }
}
