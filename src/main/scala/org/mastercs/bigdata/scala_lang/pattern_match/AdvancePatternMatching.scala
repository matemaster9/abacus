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

    val capitals = Map(
        "China" -> "Beijing",
        "America" -> "",
        "France" -> "Paris",
        "Japan" -> "Tokyo"
    )

    def capitalMatch(cap: Option[String]) = cap match {
        case Some(s) => s
        case None => "not exists"
    }

    println(capitalMatch(capitals.get("China")))

    // Scala中的for表达式可以使用元组模式来迭代元组中的元素。例如，可以使用以下代码迭代元组中的元素：
    for ((a, b) <- List((1, 2), (3, 4), (5, 6))) {
        println("a: " + a)
        println("b: " + b)
    }

    sealed trait Notification

    case class Email(sender: String, title: String, body: String) extends Notification

    case class SMS(caller: String, message: String) extends Notification

    case class VoiceRecording(contactName: String, link: String) extends Notification

    def showNotification(notification: Notification): String = notification match {
        case Email(sender, title, _) =>
            s"You got an email from $sender with title: $title"
        case SMS(number, message) =>
            s"You got an SMS from $number! Message: $message"
        case VoiceRecording(name, link) =>
            s"You received a Voice Recording from $name! Click the link to hear it: $link"
    }

    val someSms = SMS("12345", "Are you there?")
    val someVoiceRecording = VoiceRecording("Tom", "voicerecording.org/id/123")
    println(showNotification(someSms)) // prints You got an SMS from 12345! Message: Are you there?
    println(showNotification(someVoiceRecording)) // prints You received a Voice Recording from Tom! Click the link to hear it: voicerecording.org/id/123
}
