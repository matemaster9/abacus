package org.mastercs.bigdata.flink_scala.source_operator

import scala.util.Random

case class UserLoginEvent(user: String, timestamp: Long)


object UserLoginEvent {

    private val users = Array(
        "Emma", "Noah", "Olivia", "Liam", "Ava", "William", "Sophia", "Mason", "Isabella", "James", "Mia", "Benjamin",
        "Charlotte", "Jacob", "Amelia", "Michael", "Harper", "Elijah", "Evelyn", "Ethan", "Abigail", "Alexander",
        "Emily", "Daniel", "Elizabeth", "Matthew", "Sofia", "Aiden", "Madison", "Henry", "Avery", "Josephine",
        "Jackson", "Scarlett", "Samuel", "Victoria", "Sebastian", "Grace", "David", "Chloe", "Carter", "Penelope",
        "Wyatt", "Riley", "Owen", "Layla", "Grayson", "Zoey", "Gabriel", "Nora", "Julian", "Lily", "Christopher",
        "Ellie", "Joshua", "Hazel", "Andrew", "Natalie", "Lincoln", "Audrey", "Mateo", "Skylar", "Ryan", "Paisley",
        "Savannah", "Addison"
    )

    private val rdm = new Random

    def getLogs: Seq[UserLoginEvent] = users.map(user => UserLoginEvent(user, rdm.nextLong().abs)).toSeq


    def main(args: Array[String]): Unit = {
        getLogs.foreach(println)
    }
}