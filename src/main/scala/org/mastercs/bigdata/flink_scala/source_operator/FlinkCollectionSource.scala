package org.mastercs.bigdata.flink_scala.source_operator



import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment

import scala.util.Random

object FlinkCollectionSource {

    val rdm = new Random

    def main(args: Array[String]): Unit = {
        val env = StreamExecutionEnvironment.getExecutionEnvironment
        env.fromElements(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
                .map(_ + rdm.nextInt)
                .filter(_ % 2 == 0)
                .print()
        env.execute()
    }
}
