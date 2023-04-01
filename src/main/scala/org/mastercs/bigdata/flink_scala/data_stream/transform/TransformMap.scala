package org.mastercs.bigdata.flink_scala.data_stream.transform

import org.apache.flink.api.common.functions.MapFunction
import org.apache.flink.streaming.api.scala.{StreamExecutionEnvironment, createTypeInformation}
import org.mastercs.bigdata.flink_scala.data_stream.Event

object TransformMap {

    def main(args: Array[String]): Unit = {
        val env = StreamExecutionEnvironment.getExecutionEnvironment
        env.setParallelism(1)
        val source = env.fromElements(
            Event("matemaster", "mastercs.org", 1000L),
            Event("Scala", "scala-lang.org", 2000L)
        )
        source.map(event => event.user).print("1")
        source.map(new MapFunctionImpl).print("2")
        source.map(_.user).print("3")
        env.execute()
    }

    class MapFunctionImpl extends MapFunction[Event, String] {
        override def map(t: Event): String = t.user
    }
}
