package org.mastercs.bigdata_scala.features

/**
 * Description: 隐式参数
 * Author: matemaster
 * Create: 2023-04-06 12:07
 */
object ImplicitParameters {

    implicit val stringMonoid: Monoid[String] = new Monoid[String] {

        override def add(x: String, y: String): String = x + y

        override def unit: String = ""
    }

    implicit val intMonoid: Monoid[Int] = new Monoid[Int] {
        override def add(x: Int, y: Int): Int = x + y

        override def unit: Int = 0
    }

    /**
     * 隐式参数
     *
     * @param arg
     * @param m
     * @tparam A
     * @return
     */
    def sum[A](arg: List[A])(implicit m: Monoid[A]): A = {
        if (arg.isEmpty) {
            m.unit
        } else {
            m.add(arg.head, sum(arg.tail))
        }
    }

    def main(args: Array[String]): Unit = {
        println(sum(List())(stringMonoid))
        println(sum(List(1, 2, 3)))
        println(sum(List("A", "B", "C")))
    }
}

abstract class Monoid[A] {

    def add(x: A, y: A): A

    def unit: A
}
