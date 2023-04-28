package org.mastercs.bigdata_scala

/**
  * @author matemaster
  */
object ControlAbstract {

  def main(args: Array[String]): Unit = {
    println(containsNeg(List(1, 2, 3)))
    println(containsNeg(List(-1, 2, 3)))
    println(List(1, 2, 3).exists(_ < 0))
    println(List(-1, 2, 3).exists(_ < 0))
  }

  def containsNeg(numbers: List[Int]): Boolean = {
    for (elem <- numbers) {
      if (elem < 0) {
        return true
      }
    }
    false
  }
}
