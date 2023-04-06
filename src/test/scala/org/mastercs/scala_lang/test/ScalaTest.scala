package org.mastercs.scala_lang.test

import com.fasterxml.jackson.databind.ObjectMapper
import org.mastercs.bigdata.flink_scala.source_operator.CustomSourceEventLog
import org.mastercs.bigdata.flink_scala.util.JsonUtil
import org.mastercs.bigdata.scala_lang.features.ApplyMethod
import org.mastercs.bigdata.scala_lang.traits.{Blue, SealedColor}
import org.scalatest.funsuite.AnyFunSuite

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

    test("random类测试") {
        val random = new Random()
        println(random.nextInt(10 + 1).abs)
    }

    test("scala使用Jackson完成序列化") {
        // 无效，输出 {}
        val mapper = new ObjectMapper
        println(mapper.writeValueAsString(CustomSourceEventLog.getLog))

        println(JsonUtil.toJson(CustomSourceEventLog.getLog))
    }

    test("apply-method") {
        val method = ApplyMethod("sample")
        println(ApplyMethod("sample"))
        println(method.argMember)
    }
}
