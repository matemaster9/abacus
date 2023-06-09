package org.mastercs.bigdata_scala.functional_programming

import org.mastercs.bigdata_scala.functional_programming.{FuncList, TheCompanyProcess}
import org.mastercs.bigdata_scala.functional_programming.FuncList.sum
import org.scalatest.funsuite.AnyFunSuite

class FunctionalProgrammingSuite extends AnyFunSuite {

    test("函数式数据结构：FuncList") {
        println(sum(FuncList(1, 2, 3, 4, 5)))
    }

    test("TheCompanyProcess") {
        println(TheCompanyProcess.cleanNamesByFunctionalProgramming(List("mate", "master")))
    }
}
