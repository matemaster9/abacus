package org.mastercs.bigdata.scala_lang

/**
 * @author MateMaster
 * @since 2023/3/26 
 */
object ListUsingCase {

    def main(args: Array[String]): Unit = {
        firstOrder()
    }

    def listLiteral(): Unit = {
        val fruit = List("Apple", "pear", "orange")
        val numbers = List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
        val diag3 = List(
            List(1, 0, 0),
            List(0, 1, 0),
            List(0, 0, 1)
        )
        val empty = List.empty
        val empty2 = List()
    }

    def baseOpr(): Unit = {
        val numbers = List(0, 1, 2, 3)
        println(numbers.isEmpty)
        println(numbers.head)
        println(numbers.tail)
    }

    def listPattern(): Unit = {
        val fruit = List("Apple", "pear", "orange")
        val List(a, b, c) = fruit;
        println(a)
        println(b)
        println(c)

        val head :: mid :: tail = fruit
        println(head)
        println(mid)
        println(tail)
    }

    def firstOrder() = {
        val ints = List(1, 2, 3)
        // 获取长度ints.length
        println(ints.length)

        // 获取首个元素
        println(ints.head)

        // 获取除首个元素之外的元素
        println(ints.tail)

        // 获取尾部元素
        println(ints.last)

        // 获取除尾部元素之外的元素
        println(ints.init)

        // 反转
        println(ints.reverse)

        // init、tail的一般化
        val numbers = List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
        println(numbers.drop(2))
        println(numbers.take(8))
        println(numbers.splitAt(5))

        // 下标访问
        println(numbers.apply(1))
        println(numbers(1))

        // 按下标访问
        for (i <- numbers.indices) {
            println(numbers(i))
        }

        // 扁平化处理，将列表的列表变成单列表
        println(List("Apple", "pear", "orange").flatMap(_.toList))
        println(List("Apple", "pear", "orange")
                .map(_.toList)
                .flatten
        )

        // mkString
        println(List("Apple", "pear", "orange")
                .mkString("_"))

        // arr与list互换
        val array = List(0, 1, 2).toArray
        val list = Array(0, 1, 2).toList

        // 复制到数组
        val arr = new Array[Int](10)
        List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).copyToArray(arr, 0)
        println(arr.mkString("Array(", ", ", ")"))
    }
}
