package org.mastercs.bigdata_scala.oop

/**
  * 设计不可变的有理数对象
  *
  * @author matemaster
  */
class ImmutableRational(numerator: Int, denominator: Int)
    extends Ordered[ImmutableRational] {

  // 分母校验不为0
  require(denominator != 0, "denominator mustn't be 0")
  private val g = greatestCommonDivisor(numerator.abs, denominator.abs)
  val n: Int = numerator / g
  val d: Int = denominator / g

  def this(n: Int) = this(n, 1)

  override def toString: String = s"$numerator/$denominator"

  def add(that: ImmutableRational): ImmutableRational = {
    new ImmutableRational(
      this.n * that.d + this.d * that.n,
      this.d * that.d
    )
  }

  /**
    * 重载add
    *
    * @param x
    * @return
    */
  def add(x: Int): ImmutableRational = {
    add(new ImmutableRational(x))
  }

  def +(that: ImmutableRational): ImmutableRational = {
    new ImmutableRational(
      this.n * that.d + this.d * that.n,
      this.d * that.d
    )
  }

  def lessThan(that: ImmutableRational): Boolean = {
    this.n * that.d < this.d * that.n
  }

  /**
    * 最大公约数的递归实现
    *
    * @param x
    * @param y
    * @return
    */
  def greatestCommonDivisor(x: Int, y: Int): Int = {
    if (y == 0) x
    else greatestCommonDivisor(y, x % y)
  }

  /**
    * Ordered接口方法
    *
    * @param that
    * @return
    */
  override def compare(that: ImmutableRational): Int =
    (this.n * that.d) - (this.d * that.n)
}

object ImmutableRational {

  def main(args: Array[String]): Unit = {
    val rational1 = new ImmutableRational(1, 2)
    val rational2 = new ImmutableRational(1, 3)
    println(rational1 + rational2)
    println(rational1.add(rational2))
    println(rational1.add(2))
    println(rational1.lessThan(rational2))
    println(rational1 > rational2)
  }
}
