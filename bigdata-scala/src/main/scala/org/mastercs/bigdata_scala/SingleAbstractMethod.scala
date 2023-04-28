package org.mastercs.bigdata_scala

/**
  * @author matemaster
  */
object SingleAbstractMethod {

  def main(args: Array[String]): Unit = {
    val increaseOne = new IntIncreaser {
      override def increase(i: Int): Int = {
        i + 1
      }
    }

    println(applyIncrease(increaseOne, 100))
    println(applyIncrease(x => x + 10, 100))
  }

  def applyIncrease(intIncreaser: IntIncreaser, num: Int): Int = {
    intIncreaser.increase(num)
  }
}
