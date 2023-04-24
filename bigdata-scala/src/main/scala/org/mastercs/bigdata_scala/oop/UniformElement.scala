package org.mastercs.bigdata_scala.oop

class UniformElement(
                            char: Char,
                            override val height: Int,
                            override val width: Int
                    ) extends AbstractElement {

    private val line = char.toString * width

    override def contents: Vector[String] = Vector.fill(height)(line)
}
