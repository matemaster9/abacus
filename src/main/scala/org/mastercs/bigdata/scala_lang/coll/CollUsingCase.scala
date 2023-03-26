package org.mastercs.bigdata.scala_lang.coll

import scala.collection.mutable.{ArrayBuffer, ListBuffer}

object CollUsingCase {


    def main(args: Array[String]): Unit = {
        usingListBuffer()
        usingArrayBuffer()
    }

    def usingListBuffer(): Unit = {
        // 创建一个空的列表缓冲
        val buffer = ListBuffer[Int]()

        // 添加元素
        buffer += 1
        buffer += 2
        buffer += 3

        println(buffer)

        // 删除元素
        buffer -= 2

        println(buffer)

        // 添加多个元素
        buffer ++= Seq(4, 5, 6)

        println(buffer)

        // 删除多个元素
        buffer --= Seq(5, 6)

        println(buffer)

        // 清空列表缓冲
        buffer.clear()

        println(buffer)
    }

    def usingArrayBuffer(): Unit = {
        // 创建一个空的数组缓冲
        val buffer = ArrayBuffer[Int]()

        // 添加元素
        buffer += 1
        buffer += 2
        buffer += 3

        println(buffer)

        // 删除元素
        buffer -= 2

        println(buffer)

        // 添加多个元素
        buffer ++= Seq(4, 5, 6)

        println(buffer)

        // 删除多个元素
        buffer --= Seq(5, 6)

        println(buffer)

        // 清空数组缓冲
        buffer.clear()

        println(buffer)
    }
}
