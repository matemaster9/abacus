package org.mastercs.bigdata_scala.coll


object IterableColl extends App {

    val ints: List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    // iterable.grouped
    ints.grouped(2).toList.foreach(println)

    // iterable.sliding
    ints.sliding(2).toList.foreach(println)

    // 结合
    val list: List[Int] = List(1) ++ List(2)
    val list2: List[Int] = Iterable.concat(List(1), List(2)).toList

    // 映射
    List(1, 2, 3).map(_ * 2).foreach(println)
    List(
        List(2, 3),
        List(4, 5),
        List(6, 7)
    ).flatMap(list => list.map(_ * 2)).foreach(println)

    println(List(1, 2, 3)
            .groupBy(elem => elem % 2 == 0)
            .mkString(","))


}
