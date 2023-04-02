package org.mastercs.bigdata.flink_scala.source_operator

import org.apache.flink.configuration.Configuration
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment
import org.apache.flink.streaming.api.functions.source.{ParallelSourceFunction, RichSourceFunction, SourceFunction}
import org.mastercs.bigdata.flink_scala.util.JsonUtil

import java.util.concurrent.TimeUnit


object FlinkCustomizedSource {


    def main(args: Array[String]): Unit = {
        val env = StreamExecutionEnvironment.getExecutionEnvironment
        env.addSource(new CustomSource).map(value => JsonUtil.toJson(value)).print()
        env.execute()
    }

    /**
     * 生成数据：source算子，这里主要每秒种生成一个CustomSourceEventLog
     */
    class CustomSource extends SourceFunction[CustomSourceEventLog] {

        private var flag = true

        override def run(ctx: SourceFunction.SourceContext[CustomSourceEventLog]): Unit = {
            while (flag) {
                TimeUnit.SECONDS.sleep(1)
                ctx.collect(CustomSourceEventLog.getLog)
            }
        }

        override def cancel(): Unit = {
            flag = false
        }
    }

    /**
     * 主要获取数据：source算子
     */
    class CustomRichSource extends RichSourceFunction[CustomSourceEventLog] {

        // source组件生成数据的核心过程
        override def run(ctx: SourceFunction.SourceContext[CustomSourceEventLog]): Unit = ???

        // source停止生成数据
        override def cancel(): Unit = ???

        // source组件初始化
        override def open(parameters: Configuration): Unit = {
            val context = getRuntimeContext
            // 从运行时上下文获取task name
            context.getTaskName
            // 从运行时上下文获取subtask的id
            context.getIndexOfThisSubtask
        }

        // source组件销毁
        override def close(): Unit = super.close()
    }

    /**
     * 标记类型ParallelSourceFunction，表示可以并行处理
     */
    class CustomParallelSource extends ParallelSourceFunction[CustomSourceEventLog] {
        override def run(ctx: SourceFunction.SourceContext[CustomSourceEventLog]): Unit = ???

        override def cancel(): Unit = ???
    }
}
