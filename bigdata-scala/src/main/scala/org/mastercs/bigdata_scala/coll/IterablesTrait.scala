package org.mastercs.bigdata_scala.coll

/**
 * @author MateMaster
 * @since 2023/3/31 
 */
object IterablesTrait {

    def main(args: Array[String]): Unit = {

        // Scala集合统一初始化方式
        val seq = List(1, 2, 3)
        val set = Set(1, 2, 3)
        val map = Map("one" -> 1, "two" -> 2, "three" -> 3)

        // iterable特质的全部方法
        val iterable = Iterable(1, 2, 3)
        val iterator = iterable.iterator
        while (iterator.hasNext) {
            println(iterator.next)
        }
        iterable.foreach(println)
        println(iterable.isEmpty)
        println(iterable.nonEmpty)
        println(iterable.size)
        println(iterable.hasDefiniteSize)
        println(iterable.head)
        println(iterable.last)
        println(iterable.headOption)
        println(iterable.lastOption)
        println(iterable.find(_ > 1))
        println(iterable.tail)
        println(iterable.init)
        println(iterable.slice(0, 2))
        println(iterable.take(2))
        println(iterable.drop(1))
        println(iterable.takeWhile(_ < 3))
        println(iterable.dropWhile(_ < 3))
        println(iterable.filter(_ > 1))
        println(iterable.filterNot(_ > 1))
        iterable.withFilter(_ > 1).foreach(println)
        val mapped = iterable.map(_ * 2)
        mapped.foreach(println)
        val flatMapped = iterable.flatMap(i => Iterable(i, i * 2))
        flatMapped.foreach(println)
        val flattened = List(List(1), List(2)).flatten
        flattened.foreach(println)
        val collected = iterable.collect {
            case i if i > 1 => i * 2
        }
        collected.foreach(println)
    }

}
