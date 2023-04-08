package org.mastercs.bigdata.scala_lang.buildin_type

import java.time.LocalDate

/**
 * Author: matemaster
 * Create: 2023-04-06 19:26
 */
class Company(var name: String, var foundTime: LocalDate, var rank: Int) {

}

object CompanyTest {
    def main(args: Array[String]): Unit = {
        val alibaba = new Company("Alibaba", LocalDate.of(1998, 1, 1), 1)
        println(alibaba.rank)
        println(alibaba.name)
        println(alibaba.foundTime)
    }
}
