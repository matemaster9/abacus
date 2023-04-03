package org.mastercs.bigdata.flink_scala

import org.apache.flink.api.common.functions.FlatMapFunction
import org.apache.flink.streaming.api.scala.{StreamExecutionEnvironment, createTypeInformation}
import org.apache.flink.streaming.api.windowing.assigners.TumblingProcessingTimeWindows
import org.apache.flink.streaming.api.windowing.time.Time
import org.apache.flink.util.Collector


object WindowWordCount {

    def main(args: Array[String]): Unit = {
        val env = StreamExecutionEnvironment.getExecutionEnvironment
        env.socketTextStream("localhost", 9999)
                .flatMap(new BraceAbstractCtrl)
                .map((_, 1))
                .keyBy(_._1)
                .window(TumblingProcessingTimeWindows.of(Time.seconds(5)))
                .sum(1)
                .print()
        env.execute("Window Stream WordCount")

        val braceAbstractCtrl: FlatMapFunction[String, String] = (value: String, out: Collector[String]) => {
            value.toLowerCase.split("\\W+").filter(_.nonEmpty).foreach(out.collect)
        }
    }

    /**
     * 1. FlatMapFunction直接继承实现
     * 2. 花括号语法实现
     * 3. 直接lambda表达式实现
     */
    class BraceAbstractCtrl extends FlatMapFunction[String, String] {
        override def flatMap(value: String, out: Collector[String]): Unit = {
            value.toLowerCase.split("\\W+").filter(_.nonEmpty).foreach(out.collect)
        }
    }
}
