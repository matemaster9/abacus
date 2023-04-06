package org.mastercs.bigdata.scala_lang


/**
 * Description      
 * Author: matemaster
 * Create: 2023-04-05 14:10
 */
object ScalaIterable extends App {

    // iterable.iterator迭代器
    for (elem <- Iterable(1, 2, 3).iterator) {
        println(elem)
    }

    // for-each迭代
    Iterable(1, 2, 3).foreach(println)

    // 按固定长度返回迭代器
    for (elem <- Iterable(1, 2, 3, 4).grouped(2)) {
        println(elem.mkString("(", ",", ")"))
    }

    // 按滑动窗口返回迭代器，可按照指定步长滑动
    for (elem <- Iterable(1, 2, 3, 4).sliding(2)) {
        println(elem.mkString("(", ",", ")"))
    }
    for (elem <- Iterable(0, 1, 2, 3, 4, 5, 6, 7, 8, 9).sliding(2, 3)) {
        println(elem.mkString("(", ",", ")"))
    }

    // 添加
    val addIterable = Iterable(1, 2) ++ Iterable(3, 4)
    println(addIterable.mkString(","))

    // 元素映射
    val mapToLowerCase = Iterable("A", "B", "C").map(_.toLowerCase)
    println(mapToLowerCase.mkString(","))

    val numberList = List(1, 2, 3)
    val alphabetList = List("A", "B", "C")
    numberList.flatMap(number => alphabetList.map(al => al + number)).foreach(println)

    val collectFunc = new PartialFunction[Int, Int] {
        override def isDefinedAt(x: Int): Boolean = (x % 2 == 0)

        override def apply(v1: Int): Int = v1
    }
    println(Iterable(0, 1, 2, 3, 4, 5, 6, 7, 8, 9).collect(collectFunc).mkString("(", ",", ")"))

    // 与其他类型数据容器的转换
    val toArray = Iterable(0, 1, 2).toArray
    println(toArray.mkString("Array(", ", ", ")"))

    val toList = Iterable(0, 1, 2).toList
    println(toList)

    val toSeq = Iterable(0, 1, 2).toSeq
    val toSeq2 = Iterable(8, 9, 0).toSeq(1)
    println(toSeq)
    println(toSeq2)

    val toIndexSeq = Iterable(0, 1, 2, 3, 4, 5, 6, 7, 8, 9).toIndexedSeq
    println(toIndexSeq)

    val toSet = Iterable(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8, 9).toSet
    val toSet2 = Iterable(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8, 9).toSet(2)
    println(toSet)
    println(toSet2)

    val toMap = Iterable(
        ("java", 1), ("scala", 2),
        ("oop", 3), ("functional", 4)
    ).toMap
    println(toMap)

    // 复制数据到数组
    val copyArray = new Array[Int](10)
    Iterable(0, 1, 2, 3, 4, 5, 6, 7, 8, 9).copyToArray(copyArray)
    println(copyArray.mkString("Array(", ", ", ")"))

    // 大小信息
    val emptyIterable = Nil
    println(emptyIterable.isEmpty)
    println(emptyIterable.nonEmpty)
    println(emptyIterable.size)

    // 元素获取
    val queryIterable = Iterable(1, 2, 3, 4)
    println(queryIterable.head)
    println(queryIterable.headOption)
    println(queryIterable.last)
    println(queryIterable.lastOption)
    println(queryIterable.find(_ % 2 == 0))

    // 获取子序列
    val subIterable = Iterable(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
    println(subIterable.init)
    subIterable.inits.foreach(sub => println(sub.mkString("(", ",", ")")))
    println(subIterable.tail)
    subIterable.tails.foreach(sub => println(sub.mkString("(", ",", ")")))

    println(subIterable.slice(1, 8))

    println(subIterable.take(5))
    println(subIterable.takeRight(5))
    println(subIterable.takeWhile(_ % 2 != 0))

    println(subIterable.drop(5))
    println(subIterable.dropRight(5))
    println(subIterable.dropWhile(_ % 2 != 0))

    val filterIterable = subIterable.filter {
        //        print("执行一次")
        _ % 2 == 0
    }
    filterIterable.foreach(println)

    val filterIterable2 = subIterable.withFilter {
        //        print("执行一次2")
        _ % 2 == 0
    }
    filterIterable2.foreach(println)

    val filterIterable3 = subIterable.filterNot {
        //        print("执行一次3")
        _ % 2 == 0
    }
    filterIterable3.foreach(println)

    // 拉链
    println(Iterable(1, 2, 3).zip(Iterable("A", "b", "C")).toList)
    println(Iterable(0).zipAll(Iterable("A", "b", "C"), -1, "!").toList)
    println(Iterable(0, 1, 2, 3, 4, 5, 6, 7, 8, 9).zipAll(Iterable("A", "b", "C"), -1, "!").toList)

    println(List("A", "B", "C", "d").zipWithIndex)

    // 切分
    println(Iterable(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).splitAt(4))
    println(Iterable(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).span(_ % 2 == 0))
    println(Iterable(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).partition(_ % 2 == 0))

    println(Iterable(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).groupBy(e => if (e % 2 != 0) "odd" else "even"))

    // 元素测试
    println(Iterable(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).forall(_ > 0))
    println(Iterable(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).exists(_ < 0))
    println(Iterable(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).count(_ % 2 == 0))

    // 特殊折叠
    val sortedIterable = "scala-lang".toCharArray.sorted.toIterable
    println(sortedIterable.max)
    println(sortedIterable.min)

    println(Iterable(1, 2, 3).sum)
    println(Iterable(1, 2, 3).product)

    // 通用折叠
    println(Iterable(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).foldRight(2)(_ + _))
    println(Iterable(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).foldLeft(2)(_ + _))
    println(Iterable(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).reduceLeftOption(_ + _))
    println(Iterable(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).reduceRightOption(_ * _))
    println(Iterable(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).reduceOption(_ * _))

    println(Iterable(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).stringPrefix)
    println(Iterable(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).view(1, 5))
}
