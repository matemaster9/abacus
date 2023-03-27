package org.mastercs.bigdata.scala_lang

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

    class FunctionalQueue[T](private val leading: List[T], private val trailing: List[T]) {
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
}
