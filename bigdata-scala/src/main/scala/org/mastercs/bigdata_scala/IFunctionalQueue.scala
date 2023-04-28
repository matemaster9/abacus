package org.mastercs.bigdata_scala

trait IFunctionalQueue[T] {

  def head: T

  def tail: IFunctionalQueue[T]

  def enqueue(elem: T): IFunctionalQueue[T]
}

object IFunctionalQueue {

  /**
    * 伴生对象工厂方法提供实例，对外特质服务
    *
    * @param elems
    * @tparam T
    * @return
    */
  def apply[T](elems: T*): IFunctionalQueue[T] = {
    new IFunctionalQueueImpl[T](elems.toList, Nil)
  }

  /**
    * 隐藏实现类本身
    *
    * @param leading
    * @param trailing
    * @tparam T
    */
  private class IFunctionalQueueImpl[T](private val leading: List[T],
                                        private val trailing: List[T])
      extends IFunctionalQueue[T] {

    private def mirror: IFunctionalQueueImpl[T] = {
      if (leading.isEmpty) {
        new IFunctionalQueueImpl(trailing.reverse, Nil)
      } else {
        this
      }
    }

    override def head: T = mirror.leading.head

    override def tail: IFunctionalQueue[T] = {
      val q = mirror
      new IFunctionalQueueImpl(q.leading, q.trailing)
    }

    override def enqueue(elem: T): IFunctionalQueue[T] = {
      new IFunctionalQueueImpl(leading, elem :: trailing)
    }
  }
}
