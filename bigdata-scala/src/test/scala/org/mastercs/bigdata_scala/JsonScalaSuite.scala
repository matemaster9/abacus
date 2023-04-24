package org.mastercs.bigdata_scala

import org.scalatest.funsuite.AnyFunSuite

class JsonScalaSuite extends AnyFunSuite {


    test("1") {
        val json = toJson(CustomSourceEventLog.getLog)
        println(json)
        println(jacksonMapper.readValue(json, classOf[CustomSourceEventLog]))
    }
}
