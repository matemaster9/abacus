package org.mastercs.bigdata.scala_lang

object AbstractCtrl extends App {

    def twice(opr: Double => Double, arg: Double): Double = opr(opr(arg))

    println(twice(arg => arg + 100, 10.0))
    println(twice(_ + 100, 10.0))

    // 传名参数 解决类似： () => AnyRef
    def byNameAssert(predicate: => Boolean): Unit = if (!predicate) throw new AssertionError

    byNameAssert(5 > 3)
}
