package org.mastercs.bigdata.flink_scala.transformation_operator

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment
import org.mastercs.bigdata.flink_scala.source_operator.CustomSourceEventLog
import org.mastercs.bigdata.flink_scala.util.JsonUtil

import java.util
import scala.collection.JavaConverters._

object FlinkTransformation {

    def main(args: Array[String]): Unit = {
        val env = StreamExecutionEnvironment.getExecutionEnvironment
        val logsForJson = List.range(0, 10).map(_ => JsonUtil.toJson(CustomSourceEventLog.getLog))
        // scala-coll -> java-coll
        val coll: util.Collection[String] = logsForJson.asJavaCollection
        // json序列化与反序列化
        env.fromCollection(coll)
                .map(json => JsonUtil.jacksonMapper.readValue(json, classOf[CustomSourceEventLog]))
                .print()
        env.execute("obj->json->obj")
    }
}
