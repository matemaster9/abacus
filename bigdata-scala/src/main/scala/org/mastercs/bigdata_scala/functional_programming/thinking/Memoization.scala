package org.mastercs.bigdata_scala.functional_programming.thinking

/**
 * 函数式编程思维：记忆
 */
object Memoization {

    val fibonacci: Int => Int = {
        val cache = collection.mutable.Map.empty[Int, Int]

        def fib(n: Int): Int = cache.getOrElseUpdate(n, {
            if (n <= 1) n else fib(n - 1) + fib(n - 2)
        })

        fib
    }

    def main(args: Array[String]): Unit = {
        println(fibonacci(10)) // Output: 55
    }
}
