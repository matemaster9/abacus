package org.mastercs.scala_lang.test

import org.mastercs.bigdata.scala_lang.IFunctionalQueue
import org.scalatest.funsuite.AnyFunSuite

class FunctionQueueSuite extends AnyFunSuite {

    test("IFunctionQueue") {
        val value = IFunctionalQueue(1, 2, 3)
        println(value.head)
        println(value.tail)
        println(value.enqueue(2))
    }
}
