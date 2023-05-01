package org.mastercs.bigdata_scala

import scala.util.Random

object ScalaList {

  def main(args: Array[String]): Unit = {

    // copying operations: 会将列表中的内容复制到指定数组，多退少补
    val randomList = List.fill(10)(Random.nextInt(100) + 1)
    val copyRandomList = new Array[Int](10)
    println(copyRandomList.mkString("Array(", ", ", ")"))
    randomList.copyToArray(copyRandomList)
    println(copyRandomList.mkString("Array(", ", ", ")"))

    val smallCopyRandomList = new Array[Int](5)
    randomList.copyToArray(smallCopyRandomList)
    println(smallCopyRandomList.mkString("Array(", ", ", ")"))

    val bigCopyRandomList = new Array[Int](20)
    randomList.copyToArray(bigCopyRandomList)
    println(bigCopyRandomList.mkString("Array(", ", ", ")"))

    // size info
    val alphabets = List.fill(10)(Random.alphanumeric.take(5).mkString)
    println(alphabets.isEmpty)
    println(alphabets.nonEmpty)
    println(alphabets.size)

    // element retrieval
    val digits = (1 to 10).toList
    println(digits.head)
    println(digits.last)
    println(digits.headOption) // 可能存在的head
    println(digits.lastOption) // 可能存在的last
    println(digits.find(_ % 2 == 0)) // 找出第一个偶数

    // sub-collection retrieval operations
    val less10 = (0 until 10).toList
    println(less10.tail) // 2~9
    println(less10.init) // 1~8
    println(less10.slice(2,5))
  }
}
