package org.mastercs.bigdata_scala.features

import scala.util.Random

/**
  * Description
  * Author: matemaster
  * Create: 2023-04-06 18:07
  */
class CustomerId(name: String) {

  private val member = name
}

object CustomerId {
  def apply(name: String): CustomerId =
    new CustomerId(s"$name--${Random.nextLong().abs}")

  def unapply(arg: CustomerId): Option[String] = {
    val strings = arg.member.split("--")
    if (strings.tail.nonEmpty) {
      Some(strings.head)
    } else {
      None
    }
  }
}

object ExtractorObject extends App {

  val mastercs: CustomerId = CustomerId("mastercs")
  println(mastercs match {
    case CustomerId(str) => str
    case _               => ""
  })
}
