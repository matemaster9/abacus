package org.mastercs.bigdata_scala.leetcode

/**
  *
  * @author HUAWEI
  * @date 2023/4/5 12:47
  */
object Q2427 {

  def commonFactors(x: Int, y: Int): Int = {
    (1 to Math.min(x, y)).count(i => x % i == 0 && y % i == 0)
  }
}
