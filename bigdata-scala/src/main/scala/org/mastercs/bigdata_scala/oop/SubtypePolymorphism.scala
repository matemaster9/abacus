package org.mastercs.bigdata_scala.oop

/**
 * 子类型多态与动态绑定
 *
 * @author matemaster
 */
object SubtypePolymorphism extends App {

    val vector = Vector("scala-lang")
    println(AbstractElement.invokeDemo(new VectorElement(vector)))
    println(AbstractElement.invokeDemo(new LineElement("scala-lang")))
    println(AbstractElement.invokeDemo(new VectorElement2(vector)))
}
