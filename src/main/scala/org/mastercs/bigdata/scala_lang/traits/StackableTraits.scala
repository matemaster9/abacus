package org.mastercs.bigdata.scala_lang.traits

import scala.collection.mutable.ArrayBuffer

object StackableTraits extends App {

    abstract class IntQueue {

        /**
         * 将队头元素取出
         *
         * @return
         */
        def get(): Int

        /**
         * 在队列尾部加入指定元素
         *
         * @param elem
         */
        def put(elem: Int): Unit
    }

    class BasicIntQueue extends IntQueue {

        private val buf = ArrayBuffer.empty[Int]

        override def get(): Int = buf.remove(0)

        override def put(elem: Int): Unit = buf += elem
    }

    val basicIntQueue = new BasicIntQueue
    basicIntQueue.put(1)
    basicIntQueue.put(2)
    basicIntQueue.put(3)
    basicIntQueue.put(4)
    println(basicIntQueue.get())
    println(basicIntQueue.get())
    println(basicIntQueue.get())
    println(basicIntQueue.get())

    /**
     * 可将IntQueue元素扩大2倍
     */
    trait Doubling extends IntQueue {
        abstract override def put(elem: Int): Unit = super.put(2 * elem)
    }

    // 验证Doubling
    class VerifyQueue extends BasicIntQueue with Doubling

    val verifyQueue = new VerifyQueue
    verifyQueue.put(100)
    println(verifyQueue.get())

    /**
     * 可将IntQueue元素增1
     */
    trait Incrementing extends IntQueue {
        abstract override def put(elem: Int): Unit = super.put(elem + 1)
    }

    /**
     * 可过滤可将IntQueue负值元素
     */
    trait Filtering extends IntQueue {
        abstract override def put(elem: Int): Unit = if (elem >= 0) super.put(elem)
    }

    // new 实例化时混入可叠加修改特质
    val stackableTraits = new BasicIntQueue with Doubling with Filtering
    stackableTraits.put(100)
    stackableTraits.put(-100)
    println(stackableTraits.get())

    // 混入特质的顺序，靠右优先
    val rightFirst = new BasicIntQueue with Incrementing with Filtering
    rightFirst.put(-1)
    rightFirst.put(0)
    rightFirst.put(1)
    println(rightFirst.get())
    println(rightFirst.get())

    val rightFirst2 = new BasicIntQueue with Filtering with Incrementing
    rightFirst2.put(-1)
    rightFirst2.put(0)
    rightFirst2.put(1)
    println(rightFirst2.get())
    println(rightFirst2.get())
    println(rightFirst2.get())
}
