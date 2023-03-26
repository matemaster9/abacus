package org.mastercs.bigdata.scala_lang

object StringOps {


    def main(args: Array[String]): Unit = {
        // 字符串操作
        val str1 = "Hello, world!"
        val str2 = "Scala is awesome"
        val str3 = "I am learning Scala"

        // 字符串连接
        val str4 = str1 + " " + str2
        val str5 = s"$str2 and $str3"

        println(str4)
        println(str5)

        // 字符串截取
        val str6 = str1.substring(0, 5)
        val str7 = str2.substring(6)

        println(str6)
        println(str7)

        // 字符串查找
        val str8 = "world"
        val str9 = "Scala"

        println(str1.indexOf(str8))
        println(str2.indexOf(str9))

        // 字符串替换
        val str10 = str1.replace("world", "Scala")
        val str11 = str2.replaceAll("a", "A")

        println(str10)
        println(str11)

        // 字符串分割
        val str12 = "one,two,three,four,five"
        val arr1 = str12.split(",")
        val arr2 = str12.split(",", 3)

        println(arr1.mkString(", "))
        println(arr2.mkString(", "))

        // 字符串转换
        val str13 = "123"
        val num1 = str13.toInt
        val num2 = str13.toDouble

        println(num1)
        println(num2)

        // 字符串格式化
        val str14 = "Alice"
        val num3 = 25

        println("%s is %d years old.".format(str14, num3))
        println(f"$str14%s is $num3%d years old.")
    }
}
