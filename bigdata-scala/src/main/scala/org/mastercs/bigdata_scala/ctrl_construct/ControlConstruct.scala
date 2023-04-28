package org.mastercs.bigdata_scala.ctrl_construct

object ControlConstruct {

  def main(args: Array[String]): Unit = {
    // for-i循环
    val arr = Array(1, 2, 3, 4, 5)
    for (i <- arr) {
      println(i)
    }
    for (i <- 0 until arr.length) {
      println(arr(i))
    }
    for (i <- arr if i % 2 == 0) {
      println(i)
    }

    // while循环

    // do-while循环

    // for-yield

    // map

    // 实现break与continue

    // if-else
  }
}
