package org.mastercs.bigdata_scala.scala_in_action

object NumericalCases extends App {

    @throws(classOf[NumberFormatException])
    def str2Int(arg: String): Int = arg.toInt

    println(str2Int("10"))
    //    // NumberFormatException
    //    println(str2Int("s10"))

    def safeStr2Int(arg: String): Option[Int] = {
        try Some(arg.toInt)
        catch {
            case ex: NumberFormatException => None
        }
    }

    println(safeStr2Int("s10"))
    println(safeStr2Int("s10").getOrElse(100))

    val result = safeStr2Int("100") match {
        case Some(value) => value
        case None => 0
    }

    println(result)
}
