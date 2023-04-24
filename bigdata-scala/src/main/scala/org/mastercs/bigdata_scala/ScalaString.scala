package org.mastercs.bigdata_scala

class ScalaString {

}

object ScalaString {

    val member = "scala-lang"

    def main(args: Array[String]): Unit = {
        val reversed = "scala-lang".reverse
        println(reversed)

        val length = "scala-lang".length
        println(length)

        val splitString = "scala-lang".split("-", 2)
        println(splitString.mkString("(", ",", ")"))

        
    }
}
