package org.mastercs.bigdata_scala.coll

object SetUsingCase {

  def main(args: Array[String]): Unit = {
    // 创建一个空的set
    var mySet = Set.empty[String]

    // 添加元素
    mySet += "apple"
    mySet += "banana"
    mySet += "orange"

    // 删除元素
    mySet -= "banana"

    // 判断元素是否存在
    if (mySet.contains("apple")) {
      println("mySet contains apple")
    }

    // 遍历set
    for (fruit <- mySet) {
      println(fruit)
    }
  }
}
