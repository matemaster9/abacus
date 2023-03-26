package org.mastercs.bigdata.flink_scala

import org.apache.flink.api.common.JobExecutionResult
import org.apache.flink.api.scala._
import org.apache.flink.streaming.api.scala.StreamExecutionEnvironment

/**
 * @author matemaster
 */
object BatchWordCount {


    def main(args: Array[String]): Unit = {
        // 批处理WordCount
        batchWordCount(filePath = "docs/word.txt")
        // 有界流WordCount
        streamWordCount(filePath = "docs/word.txt")
    }

    def batchWordCount(filePath: String): Unit = {
        ExecutionEnvironment.getExecutionEnvironment
                .readTextFile(filePath)
                .flatMap(_.split(" "))
                .map((_, 1))
                .groupBy(0)
                .sum(1)
                .print()
    }

    def streamWordCount(filePath: String): JobExecutionResult = {
        val env = StreamExecutionEnvironment.getExecutionEnvironment
        env.readTextFile(filePath)
                .flatMap(_.split(" "))
                .map((_, 1))
                .keyBy(_._1)
                .sum(1)
                .print()

        env.execute()
    }
}
