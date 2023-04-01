package org.mastercs.bigdata.flink_scala

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment

object FlinkScala {

    def main(args: Array[String]): Unit = {
        val env = StreamExecutionEnvironment.getExecutionEnvironment
        env.setParallelism(1)

        //        env.fromElements(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
        //                .map(_ + 100)
        //                .print()

        env.readTextFile("docs/sample.txt", "UTF-8")


        env.execute()
    }
}
