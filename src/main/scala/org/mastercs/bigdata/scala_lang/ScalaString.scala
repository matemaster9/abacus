package org.mastercs.bigdata.scala_lang

object ScalaString {

    def main(args: Array[String]): Unit = {
        val reversed = "scala-lang".reverse
        println(reversed)

        val length = "scala-lang".length
        println(length)

        val splitString = "scala-lang".split("-", 2)
        println(splitString.mkString("(", ",", ")"))
    }
}
