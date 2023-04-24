package org.mastercs.bigdata_scala.currying

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

    // 三种定义求和方式
    val simpleAddFunction = (x: Int, y: Int) => x + y

    def simpleAddMethod(a: Int, b: Int): Int = {
        a + b
    }

    def simpleCurriedMethod(x: Int)(y: Int) = x + y

    // 部分应用上述函数
    val add9 = (n: Int) => simpleAddFunction(9, n)
    val add9_2 = simpleCurriedMethod(9) _
    val add9_3 = simpleCurriedMethod(9)(_)
    val add9_4 = simpleAddMethod(9, _: Int)
    // 手动函数柯里化
    val add9_5 = simpleAddFunction.curried(9)

    println(add9(1))
    println(add9_2(1))
    println(add9_3(1))
    println(add9_4(1))
    println(add9_5(1))

    //传名参数的使用
    def byName(value: => Int): Unit = println(value)

    def getValue: Int = 100

    byName(21)
    byName(getValue)
}
