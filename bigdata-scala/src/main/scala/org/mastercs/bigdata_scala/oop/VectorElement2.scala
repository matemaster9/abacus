package org.mastercs.bigdata_scala.oop

class VectorElement2(val contents: Vector[String]) extends AbstractElement {

    // 这里设计两个知识点：参数化字段、Scala允许字段重写无参方法
    // 效果等价于 class VectorElement

    override def demo: String = "VectorElement2's implementation invoked!"
}
