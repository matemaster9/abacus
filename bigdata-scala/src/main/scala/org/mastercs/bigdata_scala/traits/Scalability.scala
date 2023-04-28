package org.mastercs.bigdata_scala.traits

object Scalability extends App {

  // class Rational 出现非成员报错
  case class Rational(numerator: Int, denominator: Int)
      extends Ordered[Rational] {
    override def compare(that: Rational): Int = {
      (this.numerator * that.denominator) - (this.denominator * that.numerator)
    }
  }

  val rational1 = Rational(1, 2)
  val rational2 = Rational(1, 3)
  println(rational1 > rational2)

}
