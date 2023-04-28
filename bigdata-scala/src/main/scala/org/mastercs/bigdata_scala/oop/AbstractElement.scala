package org.mastercs.bigdata_scala.oop

/**
  * 定义抽象元素
  *
  * @author matemaster
  */
abstract class AbstractElement {

  //    def contents(): Vector[String]
  def contents: Vector[String]

  def height: Int = contents.length

  def width: Int = if (contents.isEmpty) 0 else contents(0).length

  def demo = "AbstractElement's implementation invoked!"
}

object AbstractElement {

  def invokeDemo(element: AbstractElement): String = {
    element.demo
  }
}
