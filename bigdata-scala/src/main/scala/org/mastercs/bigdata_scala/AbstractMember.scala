package org.mastercs.bigdata_scala

/**
 * 抽象成员：支持抽象类型、抽象方法、抽象val、var
 *
 * @author matemaster
 */
trait AbstractMember {
    type T

    def transform(x: T): T

    val initial: T
    var current: T
}


object AbstractMember {

    class Concrete extends AbstractMember {
        type T = String

        override def transform(x: String): String = "concrete"

        override val initial: String = "concrete"
        override var current: String = "concrete"
    }
}
