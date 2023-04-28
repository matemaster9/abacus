package org.mastercs.bigdata_scala.traits

class Person(var name: String, var age: Int) extends Speaker {
  // 辅助构造函数
  def this(name: String) {
    this(name, 0)
  }

  // 实现特质中的方法
  def speak(): String = s"My name is $name and I am $age years old."
}
