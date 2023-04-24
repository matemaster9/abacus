package org.mastercs.bigdata_scala.functional_programming

case class Cons[+A](head: A, tail: FuncList[A]) extends FuncList[A]
