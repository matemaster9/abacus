package org.mastercs.bigdata.flink_scala.source_operator

import scala.util.Random

/**
 * 业务对象
 *
 * @param uuid 唯一id
 * @param sessionId
 * @param eventId
 * @param eventInfo
 */
case class CustomSourceEventLog(uuid: Long, sessionId: String, eventId: String, eventInfo: Map[String, String])

object CustomSourceEventLog {

    /**
     * 业务事件名称
     */
    private val events = Array("appLaunch", "pageLoad", "adShow", "adClick",
        "itemShare", "itemCollect", "putBack", "wakeUp", "appClose"
    )

    /**
     * 随机类
     */
    private val rdm = new Random

    /**
     * 随机生成CustomSourceEventLog对象
     *
     * @return CustomSourceEventLog对象
     */
    def getLog: CustomSourceEventLog = {
        CustomSourceEventLog(
            rdm.nextLong.abs,
            rdm.alphanumeric.take(8).mkString,
            events(events.length - rdm.nextInt(events.length).abs),
            Map(rdm.alphanumeric.take(1).mkString -> rdm.alphanumeric.take(2).mkString)
        )
    }
}