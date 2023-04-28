package org.mastercs.bigdata_scala

/**
  * @author matemaster
  */
object Padding {

  def main(args: Array[String]): Unit = {
    println(padLines("I am matemaster \nI am coder", 20))
    println(padLines2("I am matemaster \nI am coder", 20))
  }

  def padLines(text: String, minWidth: Int): String = {
    text.linesIterator
      .map(elem => padLine(elem, minWidth))
      .mkString("\n")
  }

  private def padLine(str: String, i: Int): String = {
    if (str.length >= i) {
      str
    } else {
      str + "!" * (i - str.length)
    }
  }

  def padLines2(text: String, minWidth: Int): String = {
    def padLine(str: String, i: Int): String = {
      if (str.length >= i) {
        str
      } else {
        str + "!" * (i - str.length)
      }
    }

    text.linesIterator
      .map(elem => padLine(elem, minWidth))
      .mkString("\n")
  }
}
