package org.mastercs.bigdata.scala_lang.functional_programming

case class Cons[+A](head: A, tail: FuncList[A]) extends FuncList[A]
