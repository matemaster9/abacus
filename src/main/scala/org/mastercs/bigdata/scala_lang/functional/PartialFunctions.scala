package org.mastercs.bigdata.scala_lang.functional

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
    //    stdin.getLines().map(chatRobot).foreach(println)
    //    stdin.getLines().foreach(line => println("you input: " + chatRobot(line)))


    val valueList = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
    println(valueList.map(_ + 1).filter(_ % 2 == 0))

    val anyList = List(1, 2, 3, 4, 5, 6, 7, 8, 9, "scala-lang")
    // 偏函数过滤非数字，并数字+1
    val collectResult: List[Int] = anyList.collect(new PartialFunction[Any, Int] {
        override def isDefinedAt(x: Any): Boolean = if (x.isInstanceOf[Int]) true else false

        override def apply(v1: Any): Int = v1.asInstanceOf[Int] + 1
    })
    // 上述偏函数的简写方式
    val abridgedPartialFunc: PartialFunction[Any, Int] = {
        case v: Int => v + 1
    }
    val ints: List[Int] = anyList.collect {
        case v: Int => v + 1
    }

    println(collectResult)
    println(anyList.collect(abridgedPartialFunc))
    println(ints)

}
