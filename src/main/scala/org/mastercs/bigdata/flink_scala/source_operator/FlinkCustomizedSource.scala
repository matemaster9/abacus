package org.mastercs.bigdata.flink_scala.source_operator

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment
import org.apache.flink.streaming.api.functions.source.SourceFunction

object FlinkCustomizedSource {


    def main(args: Array[String]): Unit = {
        val env = StreamExecutionEnvironment.getExecutionEnvironment
        env.addSource(new SourceFunctionImpl)
                .map(_.timestamp)
                .print()
        env.execute()
    }

    class SourceFunctionImpl extends SourceFunction[UserLoginEvent] {

        override def run(ctx: SourceFunction.SourceContext[UserLoginEvent]): Unit = ???

        override def cancel(): Unit = ???
    }
}
