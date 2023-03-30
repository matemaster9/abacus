package org.mastercs.bigdata.scala_lang


trait AbstractMember {
    type T

    def transform(x: T): T

    val initial: T
    var current: T
}


object AbstractMember {

}
