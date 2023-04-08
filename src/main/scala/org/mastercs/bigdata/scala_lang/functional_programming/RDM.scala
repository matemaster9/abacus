package org.mastercs.bigdata.scala_lang.functional_programming

/**
 * 纯函数式随机数生成器
 * Author: matemaster
 * Create: 2023-04-08 19:22
 */
trait RDM {

    def nextInt: (Int, RDM)
}

case class SimpleRDM(seed: Long) extends RDM {
    override def nextInt: (Int, RDM) = {
        val newSeed = (seed * 0x5DEECE66DL + 0xBL) & 0xFFFFFFFFFFFFL
        val nextRDM = SimpleRDM(newSeed)
        val n = (newSeed >>> 16).toInt
        (n, nextRDM)
    }
}

object RDM extends App {

    val rdm: SimpleRDM = SimpleRDM(1000L)
    val (value, rdm2): (Int, RDM) = rdm.nextInt
    val (value2, rdm3): (Int, RDM) = rdm2.nextInt
    val (value3, rdm4): (Int, RDM) = rdm3.nextInt

    println(value)
    println(value2)
    println(value3)
}