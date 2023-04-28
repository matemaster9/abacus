package org.mastercs.bigdata_scala.oop.composition_inheritance

import org.mastercs.bigdata_scala.oop.composition_inheritance.AbstractElem.elem

/**
  * @author MateMaster
  * @since 2023/3/30
  */
abstract class AbstractElem {

  def contents: Vector[String]

  def height: Int = contents.length

  def width: Int = if (contents.isEmpty) 0 else contents(0).length

  def above(that: AbstractElem): AbstractElem = {
    elem(this.contents ++ that.contents)
  }

  override def toString: String = contents.mkString("\n")
}

object AbstractElem {

  private class VectorElem(val contents: Vector[String]) extends AbstractElem {}

  private class LineElem(arg: String) extends AbstractElem {
    override def contents: Vector[String] = Vector(arg)

    override def height: Int = 1

    override def width: Int = arg.length
  }

  private class UniformElem(
      char: Char,
      override val height: Int,
      override val width: Int
  ) extends AbstractElem {

    private val line = char.toString * width

    override def contents: Vector[String] = Vector.fill(height)(line)
  }

  def elem(contents: Vector[String]): AbstractElem = new VectorElem(contents)

  def elem(char: Char, height: Int, width: Int): AbstractElem =
    new UniformElem(char, height, width)

  def elem(arg: String): AbstractElem = new LineElem(arg)
}
