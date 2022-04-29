package pro785

import java.util.*
import kotlin.collections.HashSet

class Solution {
    fun isBipartite(graph: Array<IntArray>): Boolean {
        val setA = HashSet<Int>()
        val setB = HashSet<Int>()

        val queueA : Queue<Int> = LinkedList()
        val queueB : Queue<Int> = LinkedList()

        for (i in graph.indices) {
            if(setA.contains(i) || setB.contains(i)) {
                continue
            }
            queueA.add(i)
            while(queueA.isNotEmpty() || queueB.isNotEmpty()) {
                if(queueA.isNotEmpty()) {
                    val poll = queueA.poll()
                    if(graph[poll].any { setA.contains(it) }) {
                        return false
                    }
                    setA.add(poll)
                    queueB.addAll(graph[poll].filter { !setB.contains(it) })
                }

                if(queueB.isNotEmpty()) {
                    val poll = queueB.poll()
                    if(graph[poll].any { setB.contains(it) }) {
                        return false
                    }
                    setB.add(poll)
                    queueA.addAll(graph[poll].filter { !setA.contains(it) })
                }
            }
        }


        return true
    }
}