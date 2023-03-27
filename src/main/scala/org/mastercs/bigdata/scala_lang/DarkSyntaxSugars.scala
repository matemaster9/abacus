package org.mastercs.bigdata.scala_lang

import scala.util.Try

object DarkSyntaxSugars extends App {

    def singleArgMethod(arg: Int): String = s"$arg keeping..."

    val description = singleArgMethod(
        // biz-code
        100
    )
    println(description)


    // java.try(...)
    val tryInstance = Try {
        throw new RuntimeException
    }

    List.range(0, 10)
            .map(_ + 1)
            .foreach(println)

    // 特质实现
    trait Action {
        def act(msg: String): Unit
    }

    val printer = new Action {
        override def act(msg: String): Unit = println(msg)
    }
    printer.act("master-cs.org")

    val printerAnonymous: Action = (msg: String) => println(msg)
    printerAnonymous.act("master-cs.org")

    val sweetThread = new Thread(() => println("sweet scala-lang"))

    abstract class AnAbstractType {
        def implemented: Int = 100

        def f(msg: String): Unit
    }

    val abstractInstance: AnAbstractType = (msg: String) => println(msg)
    abstractInstance.f("scala-lang.org")


    val prependedList = 1 :: List(0)

    // ::类似实现
    class MyStream[T] {
        def -->:(value: T): MyStream[T] = this
    }

    val myStream = 1 -->: 1 -->: 1 -->: new MyStream[Int]


    // update()
    val array = Array(1, 2, 3, 4)
    array(2) = 100


    // pojo bean
    class Mutable {
        private var internalMember: Int = 0

        // getter
        def member: Int = internalMember

        // setter
        def member_=(value: Int): Unit = {
            internalMember = value
        }
    }

    val mutableContainer = new Mutable
    mutableContainer.member = 100
    println(mutableContainer.member)
}
