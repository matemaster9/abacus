package org.mastercs.bigdata.flink_scala.data_stream

import org.apache.flink.streaming.api.scala.{StreamExecutionEnvironment, createTypeInformation}

/**
 * @author MateMaster
 * @since 2023/3/28 
 */
object DataStreamAPICases {

    def main(args: Array[String]): Unit = {
        val env = StreamExecutionEnvironment.getExecutionEnvironment
        val source = env.fromCollection(UserLog.getLogs(10))
        source.map(_.seed)
                .filter(_ > 100)
                .keyBy(seed => seed)
                .print()
        env.execute()
    }

}
