package org.mastercs.bigdata.scala_lang.functional

import scala.annotation.tailrec

object PolymorphicFunction {

    def main(args: Array[String]): Unit = {
        val args = Array("I", "am", "a", "coder")
        println(findFirst(args, "a"))
        println(findAnyFirst[String](args, elem => elem == "a"))
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

    def findAnyFirst[A](args: Array[A], func: A => Boolean): Int = {
        @tailrec
        def loop(i: Int): Int = {
            if (i >= args.length) -1
            else if (func(args(i))) i
            else loop(i + 1)
        }

        loop(0)
    }
}
