package org.mastercs.bigdata_scala.pattern_match

/**
 * Scala支持的模式匹配种类
 * WildCard Pattern
 * Variable Pattern
 * Typed Pattern
 * Constant Pattern
 * Stable Pattern
 * Tuple Pattern
 * Constructor Pattern
 * Sequence Pattern
 */
object PatternMatching {


    def main(args: Array[String]): Unit = {
        val day = "Monday"
        day match {
            case "Monday" => println("Today is Monday")
            case "Tuesday" => println("Today is Tuesday")
            case "Wednesday" => println("Today is Wednesday")
            case _ => println("Today is not Monday, Tuesday or Wednesday")
        }

        // 模式匹配
        val person1 = Student("Alice", 25)
        val person2 = Student("Bob", 30)
        val person3 = Student("Charlie", 35)

        def matchPerson(person: Student): String = person match {
            case Student("Alice", 25) => "Hi Alice!"
            case Student("Bob", 30) => "Hello Bob!"
            case Student(name, age) => s"Nice to meet you, $name! You are $age years old."
        }

        println(matchPerson(person1))
        println(matchPerson(person2))
        println(matchPerson(person3))

        // 常量模式匹配
        val x: Any = "Hello"
        val y: Any = 123
        val z: Any = true

        def matchConstant(value: Any): String = value match {
            case "Hello" => "A greeting"
            case 123 => "A number"
            case true => "A boolean"
            case _ => "Unknown"
        }

        println(matchConstant(x))
        println(matchConstant(y))
        println(matchConstant(z))

        // 变量模式匹配
        val a: Any = 5
        val b: Any = "Hello"
        val c: Any = true

        def matchVariable(value: Any): String = value match {
            case i: Int => s"$i is an integer"
            case s: String => s"$s is a string"
            case b: Boolean => s"$b is a boolean"
            case _ => "Unknown"
        }

        println(matchVariable(a))
        println(matchVariable(b))
        println(matchVariable(c))


        // 序列模式匹配
        val seq1 = Seq(1, 2, 3)
        val seq2 = Seq(4, 5, 6, 7)
        val seq3 = Seq(8, 9)
        val seq4 = Seq(1, 2, 3, 4, 5)
        val seq5 = Seq(6, 7, 8, 9)
        val seq6 = Seq(10, 11, 12, 13, 14, 15)

        def matchSequence(seq: Seq[Int]): String = seq match {
            case Seq(1, 2, 3) => "Sequence 1"
            case Seq(4, 5, 6, 7) => "Sequence 2"
            case Seq(8, 9) => "Sequence 3"
            case Seq(_*) if seq.length % 2 == 0 => "Even length sequence"
            case Seq(_*) if seq.length % 2 == 1 => "Odd length sequence"
            case _ => "Unknown"
        }

        println(matchSequence(seq1))
        println(matchSequence(seq2))
        println(matchSequence(seq3))
        println(matchSequence(seq4))
        println(matchSequence(seq5))
        println(matchSequence(seq6))

        // 元组模式匹配
        val tuple1 = (1, "hello", true)
        val tuple2 = (2, "world", false)
        val tuple3 = (3, "!", true)

        def matchTuple(tuple: (Int, String, Boolean)): String = tuple match {
            case (1, "hello", true) => "Tuple 1"
            case (2, "world", false) => "Tuple 2"
            case (3, "!", true) => "Tuple 3"
            case _ => "Unknown"
        }

        println(matchTuple(tuple1))
        println(matchTuple(tuple2))
        println(matchTuple(tuple3))

        // 带类型的模式匹配
        val value1: Any = 5
        val value2: Any = "Hello"
        val value3: Any = true

        def matchType(value: Any): String = value match {
            case i: Int => s"$i is an integer"
            case s: String => s"$s is a string"
            case b: Boolean => s"$b is a boolean"
            case _ => "Unknown"
        }

        println(matchType(value1))
        println(matchType(value2))
        println(matchType(value3))

        // 带变量绑定的模式匹配
        val seq7 = Seq(1, 2, 3, 4, 5)
        val seq8 = Seq(6, 7, 8, 9)
        val seq9 = Seq(10, 11, 12, 13, 14, 15)

        def matchBindSequence(seq: Seq[Int]): String = seq match {
            case Seq(1, 2, 3) => "Sequence 1"
            case Seq(4, 5, 6, 7) => "Sequence 2"
            case Seq(8, 9) => "Sequence 3"
            case Seq(first, second, rest@_*) => s"First: $first, Second: $second, Rest: $rest"
            case _ => "Unknown"
        }

        println(matchBindSequence(seq7))
        println(matchBindSequence(seq8))
        println(matchBindSequence(seq9))

        // 带有模式守卫的match
        val person4 = Person("David", 40)
        val person5 = Person("Eva", 50)
        val person6 = Person("Frank", 60)

        def matchPersonWithGuard(person: Person): String = person match {
            case Person(name, age) if age < 30 => s"$name is young"
            case Person(name, age) if (age >= 30 && age < 50) => s"$name is middle-aged"
            case Person(name, age) if age >= 50 => s"$name is old"
        }

        println(matchPersonWithGuard(person4))
        println(matchPersonWithGuard(person5))
        println(matchPersonWithGuard(person6))

        // 构造方法模式匹配 报错，暂不支持
        val person7 = Person("Alice", 25)
        val person8 = new Person("Bob")

        def matchConstructor(person: Person): String = person match {
            case Person("Alice", 25) => "Hi Alice!"
            case Person("Bob", 0) => "Hello Bob!"
            case Person(name, age) => s"Nice to meet you, $name! You are $age years old."
        }

        println(matchConstructor(person7))
        println(matchConstructor(person8))
    }


    case class Person(name: String, age: Int) {
        def this(name: String) = {
            this(name, 0)
        }
    }
}
