package org.mastercs.bigdata.scala_lang.functional

import scala.annotation.tailrec

object PolymorphicFunction {

    def main(args: Array[String]): Unit = {
        val args = Array("I", "am", "a", "coder")
        println(findFirst(args, "a"))
        println(typeAbstractFindAnyFirst[String](args, elem => elem == "a"))
        val outOfOrderArr = Array(0, 5, 2, 9, 1)
        val ascendingArr = Array(1, 2, 3, 4, 5, 6)
        val descendingArr = Array(6, 5, 4, 3, 2, 1)
        println(typeAbstractIsSorted[Int](outOfOrderArr, (a, b) => a > b))
        println(typeAbstractIsSorted[Int](ascendingArr, (a, b) => a > b))
        println(typeAbstractIsSorted[Int](descendingArr, (a, b) => a < b))
    }

    def findFirst(args: Array[String], key: String): Int = {
        @tailrec
        def loop(i: Int): Int = {
            if (i >= args.length) -1
            else if (args(i) == key) i
            else loop(i + 1)
        }

        loop(0)
    }

    def typeAbstractFindAnyFirst[A](args: Array[A], func: A => Boolean): Int = {
        @tailrec
        def loop(i: Int): Int = {
            if (i >= args.length) -1
            else if (func(args(i))) i
            else loop(i + 1)
        }

        loop(0)
    }

    def typeAbstractIsSorted[A](args: Array[A], sorted: (A, A) => Boolean): Boolean = {

        def asc(args: Array[A], sorted: (A, A) => Boolean): Boolean = {
            for (i <- 0 until (args.length - 1)) {
                if (sorted(args(i), args(i + 1))) return false
            }
            true
        }

        def desc(args: Array[A], sorted: (A, A) => Boolean): Boolean = {
            for (i <- 0 until (args.length - 1)) {
                if (sorted(args(i), args(i + 1))) return false
            }
            true
        }

        asc(args, sorted) || desc(args, sorted)
    }
}
