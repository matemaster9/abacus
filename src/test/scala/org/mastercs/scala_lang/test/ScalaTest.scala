package org.mastercs.scala_lang.test

import org.mastercs.bigdata.scala_lang.traits.SealedColor
import org.mastercs.bigdata.scala_lang.traits.SealedColor.Blue
import org.scalatest.funsuite.AnyFunSuite

class ScalaTest extends AnyFunSuite {


    test("密封特质") {
        SealedColor.printSealedColor(Blue)
    }
}
