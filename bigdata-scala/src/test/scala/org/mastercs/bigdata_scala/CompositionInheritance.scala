package org.mastercs.bigdata_scala

import org.mastercs.bigdata_scala.oop.VectorElement
import org.scalatest.funsuite.AnyFunSuite

class CompositionInheritance extends AnyFunSuite {


    test("") {
        val element = new VectorElement(Vector("scala", "lang", "org"))
        println(element.contents)
    }

}
