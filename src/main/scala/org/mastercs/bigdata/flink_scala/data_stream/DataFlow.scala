package org.mastercs.bigdata.flink_scala.data_stream

import org.apache.flink.api.common.RuntimeExecutionMode
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment

/**
 * @author MateMaster
 * @since 2023/3/28 
 */
object DataFlow {

    def main(args: Array[String]): Unit = {
        // 获取DataStream的执行环境
        val standardEnv = StreamExecutionEnvironment.getExecutionEnvironment

        // 设置流处理程序（code显式设置）
        standardEnv.setRuntimeMode(RuntimeExecutionMode.STREAMING)

        // 执行任务
        standardEnv.execute()
    }
}
