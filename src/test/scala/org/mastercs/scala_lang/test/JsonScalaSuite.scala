package org.mastercs.scala_lang.test

import org.mastercs.bigdata.flink_scala.source_operator.CustomSourceEventLog
import org.mastercs.bigdata.flink_scala.util.JsonUtil.{jacksonMapper, toJson}
import org.scalatest.funsuite.AnyFunSuite

class JsonScalaSuite extends AnyFunSuite {


    test("1") {
        val json = toJson(CustomSourceEventLog.getLog)
        println(json)
        println(jacksonMapper.readValue(json, classOf[CustomSourceEventLog]))
    }
}
