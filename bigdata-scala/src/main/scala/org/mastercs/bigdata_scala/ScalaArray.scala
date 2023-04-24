package org.mastercs.bigdata_scala

import scala.collection.mutable

/**
 *
 * @author HUAWEI
 * @date 2023/4/5 0:37
 */
class ScalaArray {

}


object ScalaArray extends App {

    val number = 10086
    var temp = number
    val stack = new mutable.ArrayStack[Int]
    while (temp > 0) {
        stack.push(temp % 10)
        temp = temp / 10
    }
    println(stack)
    val stack2 = new mutable.ArrayStack[Int]
    stack2.push(1)
    stack2.push(2)
    stack2.push(3)
    println(stack2)
}