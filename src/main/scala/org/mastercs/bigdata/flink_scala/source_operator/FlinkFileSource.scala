package org.mastercs.bigdata.flink_scala.source_operator

import org.apache.flink.streaming.api.scala.{StreamExecutionEnvironment, createTypeInformation}

object FlinkFileSource {

    def main(args: Array[String]): Unit = {
        val environment = StreamExecutionEnvironment.getExecutionEnvironment
        environment.setParallelism(1)
        environment.readTextFile("docs/new-bing.txt")
                .flatMap {
                    _.toLowerCase.split("\\s+") filter {
                        _.nonEmpty
                    }
                }
                .map((_, 1))
                .keyBy(_._1)
                .sum(1)
                .print()
        environment.execute("new-bing word count")
    }
}
