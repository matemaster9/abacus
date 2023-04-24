package org.mastercs.bigdata_scala.scala_in_action.utils

object StringUtils {

    implicit class StringImprovement(val arg: String) {
        def increment: String = arg.map(char => (char + 1).toChar)
    }
}
