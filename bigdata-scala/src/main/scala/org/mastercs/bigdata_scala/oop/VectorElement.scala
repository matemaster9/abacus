package org.mastercs.bigdata_scala.oop

class VectorElement(vector: Vector[String]) extends AbstractElement {

    //    //字段重写无参方法
    //    override def contents: Vector[String] = vector
    val contents: Vector[String] = vector

    override def demo: String = "VectorElement's implementation invoked!"
}
