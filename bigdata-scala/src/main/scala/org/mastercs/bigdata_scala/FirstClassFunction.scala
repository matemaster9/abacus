package org.mastercs.bigdata_scala

/**
  * @author matemaster
  */
object FirstClassFunction {

  def main(args: Array[String]): Unit = {
    // 一等函数
    val increase = (x: Int) => x + 1
    println(increase(100))
    println(increase.apply(100))

    val increase100 = (x: Int) => {
      val number = 100
      x + number
    }

    println(increase100(1))
    println(increase100.apply(1))

    funcLiteral()

    // 部分应用函数全不给、部分给
    val sumV1 = sum(_, _, _)
    val sumV2 = sum _
    val sumV3 = sum(1, _, 9)
    println(sumV1.apply(1, 2, 3))
    println(sumV2.apply(1, 2, 3))
    println(sumV3.apply(2))
    println(sum(1, 2, 3))
  }

  def funcLiteral(): Unit = {
    val numbers = List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
    println(numbers.filter(item => item > 5))

    // 占位符语法实现
    println(numbers.filter(_ > 5))
  }

  def sum(x: Int, y: Int, z: Int): Int = {
    x + y + z
  }
}
