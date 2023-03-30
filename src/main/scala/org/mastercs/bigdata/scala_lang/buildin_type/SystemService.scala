package org.mastercs.bigdata.scala_lang.buildin_type

trait SystemService {

    def login(systemUser: SystemUser): Boolean

    def logout(): Unit
}