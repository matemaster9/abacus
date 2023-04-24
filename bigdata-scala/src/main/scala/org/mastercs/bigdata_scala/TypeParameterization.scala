package org.mastercs.bigdata_scala

/**
 * 实现函数式队列
 *
 * @author MateMaster
 * @since 2023/3/27
 */
object TypeParameterization extends App {

    class SlowAppendQueue[T](elems: List[T]) {
        def head: T = elems.head

        def tail = new SlowAppendQueue(elems.tail)

        def enqueue(x: T) = new SlowAppendQueue(elems ::: List(x))
    }

    class SlowHeadQueue[T](smele: List[T]) {
        def head: T = smele.last

        def tail = new SlowHeadQueue(smele.init)

        def enqueue(x: T) = new SlowHeadQueue(x :: smele)
    }

    class FunctionalQueue[T] private(private val leading: List[T], private val trailing: List[T]) {

        /**
         * 使用辅助构造，隐藏主构造
         */
        def this() = {
            this(Nil, Nil)
        }

        /**
         * 不使用this(elems: T*)为了避免与enqueue歧义
         *
         * @param elems
         */
        def this(elems: List[T]) = {
            this(elems, Nil)
        }

        private def mirror: FunctionalQueue[T] = {
            if (leading.isEmpty) {
                new FunctionalQueue(trailing.reverse, Nil)
            } else {
                this
            }
        }

        def head: T = mirror.leading.head

        def tail: FunctionalQueue[T] = {
            val q = mirror
            new FunctionalQueue(q.leading.tail, q.trailing)
        }

        def enqueue(elem: T) = new FunctionalQueue(leading, elem :: trailing)
    }

    /**
     * 伴生类apply工厂方法
     */
    object FunctionalQueue {
        def apply[T](elems: T*) = new FunctionalQueue[T](elems.to, Nil)
    }

    val functionalQueue = new FunctionalQueue[Int]()
    val value: FunctionalQueue[Int] = functionalQueue.enqueue(1)
            .enqueue(2)
            .enqueue(3)
            .enqueue(4)
    println(value.head)
    println(value.tail)

    println(FunctionalQueue(1, 2, 3).head)
}
