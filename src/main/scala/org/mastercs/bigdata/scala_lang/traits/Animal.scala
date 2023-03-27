package org.mastercs.bigdata.scala_lang.traits

trait Animal {

    def sound(): String
}

class Dog extends Animal {
    def sound(): String = "Woof"
}

class Cat extends Animal {
    def sound(): String = "Meow"
}

object Animal extends App {
    val dog = new Dog()
    val cat = new Cat()

    println(dog.sound()) // Output: Woof
    println(cat.sound()) // Output: Meow
}