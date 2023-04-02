package org.mastercs.bigdata.scala_lang.functional_programming

/**
 * 函数式编程
 */
object FunctionalProgrammings {

    def main(args: Array[String]): Unit = {
        val matchResult = FuncList(1, 2, 3, 4, 5) match {
            case Cons(x, Cons(2, Cons(4, _))) => x
            case FuncNil => 42
            case Cons(x, Cons(y, Cons(3, Cons(4, _)))) => x + y
            case Cons(h, t) => h + FuncList.sum(t)
            case _ => 101
        }

        println(matchResult)
    }
}
