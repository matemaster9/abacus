package org.mastercs.scala_lang.test

import org.mastercs.bigdata.scala_lang.oop.VectorElement
import org.scalatest.funsuite.AnyFunSuite

class CompositionInheritance extends AnyFunSuite {


    test("") {
        val element = new VectorElement(Vector("scala", "lang", "org"))
        println(element.contents)
    }

}
