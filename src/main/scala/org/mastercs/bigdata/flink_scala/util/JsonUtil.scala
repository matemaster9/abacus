package org.mastercs.bigdata.flink_scala.util

import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule

/**
 * scala使用Jackson完成序列化
 */
object JsonUtil {

    private val jacksonMapper = JsonMapper.builder()
            .addModule(DefaultScalaModule)
            .build()

    def toJson(value: AnyRef): String = jacksonMapper.writeValueAsString(value)
}
