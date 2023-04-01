package org.mastercs.bigdata.flink_scala.data_stream.transform

import org.apache.flink.api.java.functions.KeySelector
import org.apache.flink.streaming.api.scala.{StreamExecutionEnvironment, createTypeInformation}
import org.mastercs.bigdata.flink_scala.data_stream.Event

object TransformKeyBy {

    def main(args: Array[String]): Unit = {
        val env = StreamExecutionEnvironment.getExecutionEnvironment
        env.setParallelism(1)
        val source = env.fromElements(
            Event("matemaster", "mastercs.org", 1000L),
            Event("Scala", "scala-lang.org", 2000L),
            Event("blog", "matemaster.cn", 3000L)
        )
        val keyedStream = source.keyBy(_.user)
        keyedStream.min("timestamp").print()
        env.execute()
    }

    class KeySelectorImpl extends KeySelector[Event, String] {
        override def getKey(in: Event): String = in.user
    }
}
