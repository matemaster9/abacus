package org.mastercs.bigdata.flink_scala.data_stream

import scala.collection.immutable
import scala.util.Random

case class UserLog(user: String, website: String, seed: Int)

object UserLog {
    private val random = new Random

    def getLogs(count: Int): immutable.Seq[UserLog] = {
        (1 to count).map(_ => UserLog(
            s"https://www.${random.alphanumeric.take(10).mkString}.com",
            random.alphanumeric.take(10).mkString,
            random.nextInt
        ))
    }
}
