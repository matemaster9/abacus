package org.mastercs.bigdata_scala.buildin_type

trait SystemService {

  def login(systemUser: SystemUser): Boolean

  def logout(): Unit
}
