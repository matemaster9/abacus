package org.mastercs.bigdata.scala_lang.pattern_match

object AdvancePatternMatching extends App {

    val property = 100
    val mathProperty = property match {
        case m if m < 10 => "single digit"
        case m if m % 2 == 0 => "even number"
        case _ => "no property"
    }
    println(mathProperty)


    object Even {
        def unapply(arg: Int): Option[Boolean] = {
            if (arg % 2 == 0) Some(true)
            else None
        }
    }

    object SingleDigit {
        def unapply(arg: Int): Option[Boolean] = {
            if (arg < 10) Some(true)
            else None
        }
    }

    val property2 = 100
    val mathProperty2 = property2 match {
        case SingleDigit(_) => "single digit"
        case Even(_) => "even number"
        case _ => "no property"
    }
    println(mathProperty2)
}
