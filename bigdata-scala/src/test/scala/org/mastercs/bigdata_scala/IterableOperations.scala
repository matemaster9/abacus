package org.mastercs.bigdata_scala

import org.scalatest.funsuite.AnyFunSuite

import scala.util.Random

/**
  * Author: cyborg
  * Create: 2023/5/1 12:06
  */
class IterableOperations extends AnyFunSuite {

  test("addition") {
    val less5 = List(0, 1, 2, 3, 4)
    val more5 = List(5, 6, 7, 8, 9)
    println(less5.concat(more5))
    println(less5 ++ more5)
  }

  test("map") {
    val digits = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
    println(digits.map(_ * 2))

    val matrix = List(
      List(1, 2, 3),
      List(4, 5, 6),
      List(7, 8, 9)
    )
    println(matrix.flatMap(list => list.map(_ - 1)))

    val people =
      List(("mate", "developer"), ("master", "engineer"), ("cyborg", "hero"))
    val name = people.collect {
      case (_, "hreo") =>
        .1
    }
    println(name)
  }

  test("map in set、map、seq") {
    val numbers = List(1, 2, 3, 4, 5)

    val doubledNumbers = numbers.map(x => x * 2)

    // doubledNumbers 等于 List(2, 4, 6, 8, 10)
    println(doubledNumbers)

    val fruits = Set("apple", "banana", "orange")

    val capitalizedFruits = fruits.map(fruit => fruit.capitalize)

    // capitalizedFruits 等于 Set("Apple", "Banana", "Orange")
    println(capitalizedFruits)

    val scores = Map("Alice" -> 90, "Bob" -> 80, "Charlie" -> 85)

    val increasedScores = scores.map {
      case (name, score) => (name, score + 10)
    }

    // increasedScores 等于 Map("Alice" -> 100, "Bob" -> 90, "Charlie" -> 95)
    println(increasedScores)

  }

  test("toMap") {
    val companies = List(
      ("Alibaba", "mayun", 1998, 1),
      ("Tencent", "mahuateng", 1998, 2),
      ("HUAWEI", "rengzhengfei", 1987, 3)
    )
    println(companies.map(item => (item._1, item._4)).toMap)
  }

  test("specific folds") {
    val numbers = (1 to 10).toList
    println(numbers.sum)
    println(numbers.product)
    println(numbers.max)
    println(numbers.min)
    val EMPTY: List[Int] = List.empty
    println(EMPTY.maxOption)
    println(EMPTY.minOption)
  }

  test("element tests") {
    val digits = (1 until 10).toList
    println(digits.exists(_ % 2 == 0)) // true
    println(digits.forall(_ > 0)) // true
    println(digits.count(_ % 2 != 0)) // 5
  }

  test("element retrieval") {
    val digits = (1 until 10).toList
    println(digits.head)
    println(digits.last)
    println(digits.headOption)
    println(digits.lastOption)
    println(digits.find(_ > 8))
    println(digits.find(_ > 9))
  }

  test("iterator") {
    val numbers = (1 until 10).toList
    numbers.foreach(println)

    val value = numbers.grouped(3) // 按n分组迭代
    value.foreach(println)

    numbers.sliding(2).foreach(println) // x:窗口大小，y:滑动步长
    numbers.sliding(2, 1).foreach(println)
    numbers.sliding(2, 3).foreach(println)
  }

  test("sub collections") {
    val randomNumbers = List.fill(5)(Random.between(1, 100)).distinct
    println("randomNumbers: " + randomNumbers)
    println(randomNumbers.tail) // 除去第一个
    randomNumbers.tails.foreach(println) // 从左往右依次去除

    println(randomNumbers.init) // 除去最后一个
    randomNumbers.inits.foreach(println) // 从右往左依次去除

    println(randomNumbers.slice(1, 5)) // [from, to)
    println(randomNumbers.slice(0, 5))
    println(randomNumbers.slice(0, 4))

    println(randomNumbers.take(3)) // 从左往右输出前n个元素
    println(randomNumbers.drop(3)) // take(n)的补集

    println(List(1, 2, 3, 4, 9, 8, 7, 6).takeWhile(_ < 5)) // 从左到右遇见不满足条件的就停止，并返回便利结果
    println(List(1, 2, 3, 4, 9, 8, 7, 6).dropWhile(_ < 5))

    println(List(1, 2, 3, 4, 9, 8, 7, 6).takeRight(4)) // 从右往左输出前n个元素
    println(List(1, 2, 3, 4, 9, 8, 7, 6).dropRight(4))

    val digits = (1 to 9).toList
    println(digits.filter(_ % 2 == 0)) // 输出全部偶数
    println(digits.filterNot(_ % 2 == 0)) // 输出全部不是偶数
  }

  test("sub divisions") {
    val digits = (1 to 9).toList
    val tuple = digits.splitAt(4)
    println(tuple._1)
    println(tuple._2)

    val tuple1 = digits.reverse.span(_ > 5)
    println(tuple1._1)
    println(tuple1._2)

    val tuple2 = digits.partition(_ > 5)
    println(tuple2._1)
    println(tuple2._2)

    val companies = List(
      ("Alibaba", 1998),
      ("Tencent", 1998),
      ("HUAWEI", 1987)
    )

    println(companies.groupBy(_._2))
    println(companies.groupMap(_._2)(tuple => tuple._1))
  }

  test("zippers") {
    println(List("Apple", "Microsoft", "ASUS").zip(List(1, 2, 3, 4)))

    val shortList = List.fill(3)(Random.alphanumeric.take(3).mkString)
    val longList = List.fill(5)(Random.between(0, 10))
    val shortFiller = "x";
    val longFiller = 0;
    println(shortList.zipAll(longList, shortFiller, longFiller)) // 谁call zip 谁补充
    println(longList.zipAll(shortList, shortFiller, longFiller))

    println(List.fill(3)(Random.alphanumeric.take(2).mkString).zipWithIndex) // List((elem, index) ……)
  }

  test("fold") {
    val numbers = (1 to 10).toList
  }
}
