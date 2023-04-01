package org.mastercs.bigdata.scala_lang.traits

sealed trait SealedColor {


}

object SealedColor extends App {

    case object Red extends SealedColor

    case object Pink extends SealedColor

    case object Blue extends SealedColor

    def printSealedColor(color: SealedColor): Unit = color match {
        case Red => println("红色")
        case Pink => println("粉色")
        case Blue => println("蓝色")
        case _ => println("未知颜色")
    }
}
