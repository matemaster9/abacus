package org.mastercs.bigdata_scala

import org.scalatest.funsuite.AnyFunSuite

/**
 * @author MateMaster
 * @since 2023/3/31 
 */
class Iterables extends AnyFunSuite {

    test("Scala中Iterable特质的折叠操作代码") {
        val iterable = Iterable(1, 2, 3)
        val sum = iterable.foldLeft(0)(_ + _)
        println(sum)
        val product = iterable.foldLeft(1)(_ * _)
        println(product)
        val max = iterable.foldLeft(Int.MinValue)(_ max _)
        println(max)
        val min = iterable.foldLeft(Int.MaxValue)(_ min _)
        println(min)
    }


    test("Scala的iterable特质的复制操作代码") {
        val iterable = Iterable(1, 2, 3)
        val arr = new Array[Int](3)
        iterable.copyToArray(arr)
        arr.foreach(println)
    }

    test("Scala的iterable特质的大小信息操作代码") {
        val iterable = Iterable(1, 2, 3)
        println(iterable.isEmpty)
        println(iterable.nonEmpty)
        println(iterable.size)
        println(iterable.hasDefiniteSize)
    }

    test("子集合操作") {
        val iterable = Iterable(1, 2, 3)
        val grouped = iterable.grouped(2)
        grouped.foreach(println)
        val sliding = iterable.sliding(2)
        sliding.foreach(println)
    }

    test("99乘法表") {
        for (i <- 1 to 9; j <- 1 to 9) {
            if (j == 9) {
                println(i * j)
            } else {
                print(i * j + "\t")
            }
            if (i == j) {
                println()
            }
        }
    }

    test("统计字符串中字母出现的次数") {
        val str = "hello world"
        val freq = str.groupBy(identity).mapValues(_.length)
        println(freq)
    }
}
