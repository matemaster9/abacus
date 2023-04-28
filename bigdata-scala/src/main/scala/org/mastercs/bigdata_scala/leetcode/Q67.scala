package org.mastercs.bigdata_scala.leetcode

/**
  *
  * @author HUAWEI
  * @date 2023/4/5 1:05
  */
object Q67 {

  def addBinary(a: String, b: String): String = {
    (BigInt.apply(a, 2) + BigInt.apply(b, 2)).toString(2)
  }

  def plusOne(digits: Array[Int]): Array[Int] = {
    (BigInt(digits.mkString) + 1).toString
      .map(char => char.toString.toInt)
      .toArray
  }

  def main(args: Array[String]): Unit = {
//        println(plusOne(Array(1, 2, 3)).mkString("Array(", ", ", ")"))

//        println((Array(9, 8, 7, 6, 5, 4, 3, 2, 1, 0).mkString.toInt + 1).toString.map(char => char.toString.toInt).toArray.mkString("Array(", ", ", ")"))

    val string = Array(9, 8, 7, 6, 5, 4, 3, 2, 1, 0).mkString

    println(
      (BigInt(string) + 1)
        .toString(10)
        .map(char => char.toString.toInt)
        .toArray
        .mkString("Array(", ", ", ")"))
  }

}
