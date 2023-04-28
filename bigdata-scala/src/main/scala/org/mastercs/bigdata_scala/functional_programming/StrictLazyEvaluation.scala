package org.mastercs.bigdata_scala.functional_programming

object StrictLazyEvaluation {

  def main(args: Array[String]): Unit = {
    val ints = List(1, 2, 3, 4).map(_ + 10).filter(_ % 2 == 0).map(_ * 3)
    println(ints)

    def squareDouble(x: Double): Double = x * x
    //        // java.lang.RuntimeException: 调用失败
    //        squareDouble(sys.error("调用失败"))
    println(squareDouble(2))

    // 惰性求值
    // 自定义if函数，查看Scala的if结构是惰性求值
    def ifFunc[A](condition: Boolean, onTrue: => A, onFalse: => A): A = {
      if (condition) onTrue else onFalse
    }

    println(ifFunc(condition = false, sys.error("不被调用"), 3))

    def maybeTwice(condition: Boolean, i: => Int): Int = {
      if (condition) i + i else 0
    }

    def maybeTwice2(condition: Boolean, i: => Int): Int = {
      if (condition) {
        lazy val j = i
        j + j
      } else {
        0
      }
    }

    def maybeTwice3(condition: Boolean, i: => Int): Int = {
      if (condition) {
        val j = i
        j + j
      } else {
        0
      }
    }

    // 2个hi
    maybeTwice(true, {
      println("hi")
      10
    })
    // 1个hi
    maybeTwice2(true, {
      println("hi")
      10
    })
    // 1个hi
    maybeTwice3(true, {
      println("hi")
      10
    })
  }
}
