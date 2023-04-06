package org.mastercs.bigdata.scala_lang.features


/**
 * Description      
 * Author: matemaster
 * Create: 2023-04-06 13:35
 */
object Covariance {

    /**
     * List[+A] 协变
     *
     * @param animals
     */
    def printAnimals(animals: List[Animal]): Unit = {
        animals.foreach(animal => println(animal.name))
    }

    /**
     * 逆变
     *
     * @param printer
     */
    def prtlnDog(printer: Printer[Dog]): Unit = {
        val myDog = Dog("kimi")
        printer.prtln(myDog)
    }

    def main(args: Array[String]): Unit = {
        printAnimals(List(Dog("jack")))
        printAnimals(List(Cat("tom")))
        prtlnDog(new DogPrinter) // The dog name is Dog(kimi)
        prtlnDog(new AnimalPrinter) // The animal name is Dog(kimi)
    }
}

abstract class Animal {
    def name: String
}

case class Dog(name: String) extends Animal

case class Cat(name: String) extends Animal


abstract class Printer[-A] {
    def prtln(value: A): Unit
}

class DogPrinter extends Printer[Dog] {
    override def prtln(value: Dog): Unit = println(s"The dog name is ${value}")
}

class CatPrinter extends Printer[Cat] {
    override def prtln(value: Cat): Unit = println(s"The cat name is ${value}")
}

class AnimalPrinter extends Printer[Animal] {
    override def prtln(value: Animal): Unit = println(s"The animal name is ${value}")
}
