package org.mastercs.bigdata.scala_lang.features

/**
 * Description scala-lang
 * Author: matemaster
 * Create: 2023-04-06 18:25
 */

class Graph {

    var nodes: List[Node] = List.empty

    class Node {
        var connectNodes: List[Node] = List.empty

        def connectTo(node: Node): Unit = {
            if (!connectNodes.exists(node.equals)) {
                connectNodes = node :: connectNodes
            }
        }
    }

    def newNode: Node = {
        val res = new Node
        nodes = res :: nodes
        res
    }
}

object InnerClass extends App {

}
