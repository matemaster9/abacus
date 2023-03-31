package org.mastercs.bigdata.scala_lang.traits

trait Animal {

    def sound(): String
}

object Animal extends App {

    class Dog extends Animal {
        def sound(): String = "Woof"
    }

    class Cat extends Animal {
        def sound(): String = "Meow"
    }

    val dog = new Dog()
    val cat = new Cat()

    println(dog.sound()) // Output: Woof
    println(cat.sound()) // Output: Meow
}