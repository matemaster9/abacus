package org.mastercs.bigdata.flink_scala.data_stream.transform

import org.apache.flink.api.common.functions.FilterFunction
import org.apache.flink.streaming.api.scala.{StreamExecutionEnvironment, createTypeInformation}
import org.mastercs.bigdata.flink_scala.data_stream.Event

object TransformFilter {


    def main(args: Array[String]): Unit = {
        val env = StreamExecutionEnvironment.getExecutionEnvironment
        env.setParallelism(1)
        val source = env.fromElements(
            Event("matemaster", "mastercs.org", 1000L),
            Event("Scala", "scala-lang.org", 2000L)
        )
        source.filter(event => event.timestamp > 1000L).print("1")
        source.filter(new FilterFunctionImpl).print("2")
        source.filter(_.timestamp > 1000L).print("3")
        env.execute()
    }

    class FilterFunctionImpl extends FilterFunction[Event] {
        override def filter(t: Event): Boolean = t.timestamp > 1000L
    }
}
