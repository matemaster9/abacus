package org.mastercs.bigdata.scala_lang

import scala.collection.immutable.HashMap

/**
 * Scala入门案例
 *
 * @author matemaster
 */
object GettingStartedScalaLang {

    def main(args: Array[String]): Unit = {
        // 使用var、val
        var number = 100
        val message = "Getting started scala"

        // while循环
        var i = 0
        while (i < 10) {
            println(i)
            i += 1
        }

        // for循环
        val numbers = Array(0, 1, 2, 3)
        for (elem <- numbers) {
            println(elem)
        }

        for (i <- numbers.indices) {
            println(numbers(i))
        }

        for (i <- 0 to 10) {
            println(i)
        }

        for (i <- 0 until 10) {
            println(i)
        }

        numbers.foreach(println)

        // 参数类型化数组
        val numbers2 = new Array[Int](2)
        numbers2(0) = 1
        numbers2.update(1, 2)

        // list使用
        val empty = List.empty
        val empty2 = Nil
        val list = 1 :: empty
        val list2 = List(1) ::: empty2

        // 元组使用
        val pair = ("one", 1)

        // 集和映射使用
        val query = Set("scala", "java")

        val provinceMap = HashMap("anhui" -> "hefei", "zhejiang" -> "hangzhou")

        def printArgs(args: String*) = args.foreach(println)

        def formatArgs(args: String*): String = args.mkString("\n")

        println(formatArgs("scalable", "language"))
    }
}
