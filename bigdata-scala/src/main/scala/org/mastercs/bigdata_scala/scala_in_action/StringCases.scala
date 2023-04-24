package org.mastercs.bigdata_scala.scala_in_action

import org.mastercs.bigdata_scala.scala_in_action.utils.StringUtils.StringImprovement

import scala.util.matching.Regex

object StringCases extends App {

    // 字符串相等性质比较
    val str = "scala-lang"
    val str2 = "scala" + "-" + "lang"
    println(str == str2)

    // 多行字符串
    val multilineString =
        """SELECT column1, column2, ...
          |FROM table_name
          |ORDER BY column1, column2, ... ASC|DESC;""".stripMargin
    println(multilineString)

    // 字符串分割
    val str3 = "scala-lang"
    val words: Array[String] = str3.split("-")
    println(words.forall(str => str.isEmpty))
    println(words.forall(_.isEmpty))

    // 字符串中的变量代换
    words.foreach(word => println(s"This word is $word"))
    words.foreach(word => println(s"The length of the word is ${word.length}"))

    // 遍历处理字符串的每个字符
    val msg = "scala lang"
    println(msg.map(_.toUpper))
    println(for (m <- msg) yield m.toUpper)
    msg.foreach(char => print(char.toUpper))

    // 字符串的正则匹配
    val regex: Regex = "Scala".r
    val message = "Scala-Lang is scalable and cool"
    println(regex.findFirstIn(message))
    println(regex.findAllIn(message).toArray.mkString("Array(", ", ", ")"))

    val regex2 = "[0-9]".r
    val message2 = "scala-lang is bigdata language 111, 222, 333"
    println(regex2.findAllIn(message2).toArray.mkString("Array(", ", ", ")"))

    // Adler-32
    object Alder32Checksum {
        val MOD_ADLER = 65221

        def checksum(arg: String): Int = {
            var a = 1
            var b = 0

            arg.getBytes.foreach(bit => {
                a = (bit + a) % MOD_ADLER
                b = (b + a) % MOD_ADLER
            })

            (b << 16) + a
        }
    }

    val sum: Int = Alder32Checksum.checksum("scala-lang")
    printf("checksum (Int) = %d\n", sum)
    printf("checksum (Hex) = %s\n", sum.toHexString)

    // 访问指定位置的字符
    val name = "mate-master"
    for (i <- name.indices) {
        print(name(i))
    }
    println()

    // 在String中加入自定义方法，详情可看org.mastercs.bigdata.scala_lang.scala_in_action.utils.StringUtils.StringImprovement
    println("Alibaba".increment)


}
