package org.mastercs.bigdata.scala_lang.functional

import scala.io.Source.stdin

object PartialFunctions extends App {


    class FunctionApplicableFunction extends RuntimeException

    // Function[Int:Int] === Int => Int
    val fussyFunction = (x: Int) => {
        if (x == 1) 100
        else if (x == 2) 10000
        else throw new FunctionApplicableFunction
    }

    // Int match
    val nicerFussyFunction = (x: Int) => x match {
        case 1 => 100
        case 2 => 10000
    }

    // PartialFunction value
    val partialFunction: PartialFunction[Int, Int] = {
        case 1 => 100
        case 2 => 10000
    }

    // 非case报错
    println(fussyFunction(1))
    println(nicerFussyFunction(2))
    println(partialFunction(2))

    // PartialFunction util
    println(partialFunction.isDefinedAt(100))
    val lifted = partialFunction.lift

    // Int => Option[Int]
    println(lifted(2))
    println(lifted(100))

    val pfChain = partialFunction.orElse[Int, Int] {
        case 3 => 1000000
    }
    println(pfChain(3))

    /**
     * 控制台输入
     * stdin.getLines().foreach(line => println("you input: " + line))
     */

    val chatRobot: PartialFunction[String, String] = {
        case "login" => "welcome to scala-lang"
        case "logout" => "bye scala-lang"
        case _ => "invalid input"
    }
    stdin.getLines().map(chatRobot).foreach(println)
//    stdin.getLines().foreach(line => println("you input: " + chatRobot(line)))

}
