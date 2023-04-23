package org.mastercs.bigdata.scala_lang

import scala.annotation.tailrec

/**
 * @author matemaster
 */
object Closure {


    def main(args: Array[String]): Unit = {
        // 使用闭包创建一个新的函数 add5
        val add5 = addX(5)

        // 调用 add5，并输出结果 10
        println(add5(5))

        println(sum(1, 2, 3))
        println(sumRec(1, 2, 3))
        println(sumTo(3))
    }

    // 定义一个接受整型参数 x 的函数，并返回一个新的函数
    def addX(x: Int): Int => Int = {
        // 返回一个新的函数，该函数接受整型参数 y，并返回 x + y 的结果
        def addY(y: Int): Int = x + y

        addY
    }

    /** **************************柯里化（Currying）*************************************** */
    def add(x: Int, y: Int): Int = x + y

    // 将 add 转换为柯里化函数 addX 和 addXY
    def addXCurrying(x: Int)(y: Int): Int = x + y

    def addXY(): Int => Int = addXCurrying(2) // 使用部分施用将 x 固定为 2

    /** **************************部分施用（Partial Application）************************* */
    def sum(x: Int, y: Int, z: Int): Int = x + y + z

    // 将 sum 转换为部分施用函数 sumTo 和 sumRec
    def sumTo(n: Int): Int = {
        // 定义一个新的闭包函数 rec，它接受两个整数参数 x 和 acc，并返回一个整数值
        @tailrec
        def rec(x: Int, acc: Int): Int = {
            if (x > n) acc
            else rec(x + 1, acc + x)
        }

        rec(1, 0) // 初始值为 (1, 0)
    }

    val sumRec: (Int, Int, Int) => Int = sum _ // 将 sum 转换为部分施用函数 sumRec

    def price(product: String): Double = product match {
        case "apples" => 140
        case "oranges" => 223
    }

    def withTax(cost: Double, state: String): Double = state match {
        case "NY" => cost * 2
        case "FL" => cost * 3
    }

    val locallyTaxed: Double => Double = withTax(_: Double, "NY")
    val costOfApples: Double = locallyTaxed(price("apples"))
    assert(Math.round(costOfApples) == 280)
}
