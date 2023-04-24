package org.mastercs.bigdata_scala.functional_programming

trait FuncList[+A]


object FuncList {

    def sum(ints: FuncList[Int]): Int = ints match {
        case FuncNil => 0
        case Cons(x, xs) => x + sum(xs)
    }

    def apply[A](as: A*): FuncList[A] = {
        if (as.isEmpty) FuncNil
        else Cons(as.head, apply(as.tail: _*))
    }
}


