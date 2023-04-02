package org.mastercs.bigdata.flink_scala.util

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule

/**
 * scala使用Jackson完成序列化
 */
object JsonUtil {

    val jacksonMapper: JsonMapper = JsonMapper.builder()
            .addModule(DefaultScalaModule)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .build()

    def toJson(value: AnyRef): String = jacksonMapper.writeValueAsString(value)
}
