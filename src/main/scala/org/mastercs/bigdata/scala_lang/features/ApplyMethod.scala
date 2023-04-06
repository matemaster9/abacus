package org.mastercs.bigdata.scala_lang.features

/**
 * Description: 验证apply函数的作用
 * Author: matemaster
 * Create: 2023-04-06 17:56
 */

class ApplyMethod(arg: String) {

    val argMember: String = arg

    override def toString: String = arg
}


object ApplyMethod {

    def apply(arg: String): ApplyMethod = new ApplyMethod(arg)

}
