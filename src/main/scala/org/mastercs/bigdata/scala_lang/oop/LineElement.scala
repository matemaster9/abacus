package org.mastercs.bigdata.scala_lang.oop

class LineElement(elem: String) extends VectorElement(Vector(elem)) {

    // 直接调用父类的构造函数

    override def demo: String = "LineElement's implementation invoked!"
}
