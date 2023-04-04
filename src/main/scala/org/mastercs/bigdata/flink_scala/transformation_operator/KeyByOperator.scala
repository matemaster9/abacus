package org.mastercs.bigdata.flink_scala.transformation_operator

import org.apache.flink.streaming.api.scala.{DataStream, StreamExecutionEnvironment, createTypeInformation}
import org.mastercs.bigdata.flink_scala.data_stream.Event

object KeyByOperator extends App {

    val env = StreamExecutionEnvironment.getExecutionEnvironment
    val source: DataStream[Event] = env.fromElements(
        Event("matemaster", "mastercs.org", 1000L),
        Event("tomcat", "apache.org", 2000L),
        Event("scala", "scala-lang.org", 6000L),
        Event("scala", "scala-lang.org", 5000L),
        Event("java", "openjdk.org", 2000L)
    )
    source.keyBy(_.user).max("timestamp").print()
    env.execute("keyBy算子")


    val env2 = StreamExecutionEnvironment.getExecutionEnvironment
    val source2: DataStream[(String, Int)] = env2.fromElements(
        ("a", 1), ("b", 2), ("c", 3), ("a", 3), ("b", 5)
    )
    source2.keyBy(_._1).sum(1).print()
    source2.keyBy(_._1).print()
    //    source2.keyBy(_._1).max(1).print()
    //    source2.keyBy(_._1).min(1).print()
    //    source2.keyBy(_._1).maxBy(1).print()
    //    source2.keyBy(_._1).minBy(1).print()
    env2.execute("简单聚合算子")

    val env3 = StreamExecutionEnvironment.getExecutionEnvironment
    val source3: DataStream[(String, Int)] = env3.fromElements(
        ("a", 1), ("b", 2), ("c", 3), ("a", 3), ("b", 5)
    )
    source3.map(t => (t._1, 1L))
            .keyBy(_._1)
            .reduce((t, t1) => (t._1, t._2 + t1._2))
            .keyBy(_ => true)
            .reduce((state, data) => if (state._2 > data._2) state else data)
            .print()
    env3.execute("归约聚合算子")
}
