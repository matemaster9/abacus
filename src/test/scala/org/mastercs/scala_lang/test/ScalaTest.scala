package org.mastercs.scala_lang.test

import org.scalatest.funsuite.AnyFunSuite

import scala.io.Source

class ScalaTest extends AnyFunSuite {


    test("new-bing") {
        val source = Source.fromFile("docs/new-bing.txt")
        source.mkString.split("\\s+")
                .groupBy(word => word)
                .mapValues(_.length)
                .foreach(println)
        source.close()
    }
}
