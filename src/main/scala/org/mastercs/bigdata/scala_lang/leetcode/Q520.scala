package org.mastercs.bigdata.scala_lang.leetcode

object Q520 {

    def detectCapitalUse(word: String): Boolean = {
        if (word == word.toUpperCase) {
            return true
        }
        if (word == word.toLowerCase) {
            return true
        }
        if (word.head == word.toUpperCase.head && word.tail == word.toLowerCase.tail) {
            return true
        }
        false
    }

    def main(args: Array[String]): Unit = {
        println(Q520.detectCapitalUse("USA"))
        println(Q520.detectCapitalUse("Usa"))
        println(Q520.detectCapitalUse("usa"))
        println(Q520.detectCapitalUse("usSa"))
    }
}
