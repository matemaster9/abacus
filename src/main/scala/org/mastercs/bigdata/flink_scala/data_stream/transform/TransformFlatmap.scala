package org.mastercs.bigdata.flink_scala.data_stream.transform

import org.apache.flink.api.common.functions.FlatMapFunction
import org.apache.flink.streaming.api.scala.{StreamExecutionEnvironment, createTypeInformation}
import org.apache.flink.util.Collector
import org.mastercs.bigdata.flink_scala.data_stream.Event

object TransformFlatmap {


    def main(args: Array[String]): Unit = {
        val env = StreamExecutionEnvironment.getExecutionEnvironment
        env.setParallelism(1)
        val source = env.fromElements(
            Event("matemaster", "mastercs.org", 1000L),
            Event("Scala", "scala-lang.org", 2000L)
        )
        source.flatMap(new FlatMapFunctionImpl).print("1")
        env.execute()
    }

    class FlatMapFunctionImpl extends FlatMapFunction[Event, String] {
        override def flatMap(t: Event, collector: Collector[String]): Unit = {
            if (t.user == "matemaster") {
                collector.collect(t.user)
            } else if (t.user == "Scala") {
                collector.collect(t.user)
                collector.collect(t.url)
            }
        }
    }
}
