package org.mastercs.bigdata_scala.functional_programming

/**
 * @author matemaster
 */
object TheCompanyProcess {

    def cleanNamesByFunctionalProgramming(nameList: List[String]): String = {
        if (nameList == null || nameList.isEmpty) {
            return null
        }
        nameList
                .filter(str => str != null && str.nonEmpty)
                .map(capitalizeString)
                .mkString(",")
    }

    def capitalizeString(str: String): String = {
        str.substring(0, 1).toUpperCase + str.substring(1)
    }
}
