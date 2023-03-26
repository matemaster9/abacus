package org.mastercs.bigdata.scala_lang.pattern_match

trait Expr {
    case class Var(name: String) extends Expr

    case class Num(number: Double) extends Expr

    case class UnOp(operator: String, arg: Expr) extends Expr

    case class BinOp(operator: String, left: Expr, right: Expr) extends Expr
}