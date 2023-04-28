package org.mastercs.bigdata_scala.traits

/**
  * sealed class 必须与子类型在统一文件
  */
sealed trait SealedColor {}

case object Red extends SealedColor

case object Pink extends SealedColor

case object Blue extends SealedColor

object SealedColor extends App {

  def printSealedColor(color: SealedColor): Unit = color match {
    case Red  => println("红色")
    case Pink => println("粉色")
    case Blue => println("蓝色")
  }
}
