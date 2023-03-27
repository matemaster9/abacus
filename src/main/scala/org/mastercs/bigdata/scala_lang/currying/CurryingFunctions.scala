package org.mastercs.bigdata.scala_lang.currying

object CurryingFunctions extends App {

    val superAdder: Int => Int => Int = x => y => (x + y)
    println(superAdder(3)(5))

    val add100 = superAdder(100)
    println(add100(1))


    def curriedFunc(x: Int)(y: Int): Int = {
        x + y
    }

    val add10000: Int => Int = curriedFunc(10000)
    println(add10000(1))
    println(curriedFunc(10000)(1))


    def twice(op: Double => Double, number: Double) = op(op(number))

    println(twice(num => num * num, 100.0))
}
