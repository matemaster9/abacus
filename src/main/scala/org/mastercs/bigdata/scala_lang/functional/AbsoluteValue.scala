package org.mastercs.bigdata.scala_lang.functional

import scala.annotation.tailrec

object AbsoluteValue {


    def main(args: Array[String]): Unit = {
        println(formatAbs(-10))
        println(factorial(3))
        println(fib(6))
    }


    def formatAbs(x: Int): String = {

        def abs(m: Int): Int = {
            if (m < 0) -m else m
        }

        val message = "The absolute value of %d is %d"
        message.format(x, abs(x))
    }

    /**
     * x阶乘l
     *
     * @param x x!
     * @return
     */
    def factorial(x: Int): Int = {
        // 尾递归优化注解
        @tailrec
        def go(n: Int, acc: Int): Int = {
            if (n <= 0) acc
            else go(n - 1, n * acc)
        }

        go(x, 1)
    }

    /**
     * 斐波拉契数 0, 1, 1, 2, 3, 5……
     *
     * @param x fib(x)
     * @return
     */
    def fib(x: Int): Int = {
        def unit(m: Int, n: Int, o: Int): Int = {
            if (m == 1) n
            else if (m == 2) o
            else unit(m - 1, n, o) + unit(m - 2, n, o)
        }

        unit(x, 0, 1)
    }
}
