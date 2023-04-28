package org.mastercs.bigdata_scala

/**
  * @author matemaster
  */
object SpecialFunction {

  def main(args: Array[String]): Unit = {
    echo("mastercs", "org")
    println(speed(distance = 100.0, time = 10.0))
    println(defaultSum(10))
    println(defaultAllSum())
  }

  def echo(args: String*): Unit = {
    args.foreach(println)
  }

  def speed(distance: Double, time: Double): Double = {
    distance / time
  }

  def defaultSum(number: Int, defaultNumber: Int = 0): Int = {
    number + defaultNumber
  }

  def defaultAllSum(number: Int = 0, defaultNumber: Int = 0): Int = {
    number + defaultNumber
  }
}
