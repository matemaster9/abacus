package org.mastercs.scala_lang.test

import org.mastercs.bigdata.scala_lang.traits.SealedColor
import org.mastercs.bigdata.scala_lang.traits.SealedColor.Blue
import org.scalatest.funsuite.AnyFunSuite

import scala.io.Source

import scala.io.Source
import scala.util.Random

class ScalaTest extends AnyFunSuite {


    test("new-bing") {
        val source = Source.fromFile("docs/new-bing.txt")
        source.mkString.split("\\s+")
                .groupBy(word => word)
                .mapValues(_.length)
                .foreach(println)
        source.close()
    }
    test("密封特质") {
        SealedColor.printSealedColor(Blue)
    }

    test("生成十个随机网址") {
        val random = new Random

        val urls = (1 to 10).map { _ =>
            s"https://www.${random.alphanumeric.take(10).mkString}.com"
        }

        urls.foreach(println)
    }

    test("Scala将文件数据读取到集合中代码") {
        val source = Source.fromFile("docs/users.txt")
        println(source.getLines().toArray.mkString("Array(", ", ", ")"))
        source.close()
    }
}
