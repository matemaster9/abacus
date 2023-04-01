package org.mastercs.bigdata.flink_scala

import org.apache.flink.streaming.api.scala.{StreamExecutionEnvironment, createTypeInformation}
import org.apache.flink.streaming.api.windowing.assigners.TumblingProcessingTimeWindows
import org.apache.flink.streaming.api.windowing.time.Time


object WindowWordCount {

    def main(args: Array[String]): Unit = {
        val env = StreamExecutionEnvironment.getExecutionEnvironment
        env.socketTextStream("localhost", 9999)
                .flatMap {
                    _.toLowerCase.split("\\W+") filter {
                        _.nonEmpty
                    }
                }
                .map((_, 1))
                .keyBy(_._1)
                .window(TumblingProcessingTimeWindows.of(Time.seconds(5)))
                .sum(1)
                .print()
        env.execute("Window Stream WordCount")
    }
}
