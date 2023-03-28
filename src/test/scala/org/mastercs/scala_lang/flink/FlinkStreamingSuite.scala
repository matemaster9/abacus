package org.mastercs.scala_lang.flink

import org.apache.flink.api.common.serialization.SimpleStringSchema
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer
import org.mastercs.bigdata.flink_scala.data_stream.Event
import org.scalatest.funsuite.AnyFunSuite

import java.util.Properties

/**
 * @author MateMaster
 * @since 2023/3/28 
 */
class FlinkStreamingSuite extends AnyFunSuite {


    test("fromElements") {
        val env = StreamExecutionEnvironment.getExecutionEnvironment

        // 有界流获取数据
        env.fromElements(Event("master", "www.mastercs.org", 1000L),
            Event("scala", "www.scala-lang.org", 1000L),
            Event("java", "www.openjdk.org", 1000L),
            Event("python", "www.python.org", 1000L),
        ).print()

        env.execute()
    }

    test("flink-connector-kafka") {

        val env = StreamExecutionEnvironment.getExecutionEnvironment

        env.setParallelism(1)

        val props = new Properties()
        props.setProperty("", "")
        props.setProperty("", "")
        props.setProperty("", "")

        val dataStreamSource = env.addSource(new FlinkKafkaConsumer[String]("topic", new SimpleStringSchema(), props))

        dataStreamSource.print()

        env.execute()
    }
}
