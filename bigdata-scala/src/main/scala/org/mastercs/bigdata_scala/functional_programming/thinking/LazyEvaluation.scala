package org.mastercs.bigdata_scala.functional_programming.thinking

/**
  * 延迟求值
  */
object LazyEvaluation {
  val x: Int = {
    println("Evaluating x")
    1 + 2
  }

  lazy val y: Int = {
    println("Evaluating y")
    3 + 4
  }

  def z: Int = {
    println("Evaluating z")
    5 + 6
  }

  def main(args: Array[String]): Unit = {}
}
