package org.mastercs.bigdata_scala

/**
  * @author matemaster
  */
object MultiAbstractMethod {

  def main(args: Array[String]): Unit = {

    val mathOpr = new MathOpr {
      override def add(x: Int, y: Int): Int = {
        x + y
      }

      override def minus(x: Int, y: Int): Int = {
        x - y
      }

      override def multi(x: Int, y: Int): Int = {
        x * y
      }

      override def division(x: Double, y: Double): Double = {
        x / y
      }
    }

    println(mathOpr.add(1, 2))
    println(mathOpr.minus(1, 2))
    println(mathOpr.multi(1, 2))
    println(mathOpr.division(1, 2))
  }
}
