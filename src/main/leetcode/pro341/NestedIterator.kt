package pro341

// https://leetcode.com/problems/flatten-nested-list-iterator/
class NestedIterator(nestedList: List<NestedInteger>) {
    private val nestedList = nestedList
    private val cursors = ArrayList<Int>()
    private var returnVal : Int = 0
    fun next(): Int {
        return returnVal
    }

    fun hasNext(): Boolean {
        if (nestedList.isEmpty()) {
            return false
        }

        return hasNext(nestedList, 0)
    }

    private fun hasNext(list: List<NestedInteger>?, depth: Int): Boolean {
        if (list.isNullOrEmpty()) {
            return false
        }
        if(cursors.size == depth) {
            cursors.add(0)
        }

        while (cursors[depth] < list.size) {
            if (list[cursors[depth]].isInteger()) {
                returnVal = list[cursors[depth]].getInteger()!!
                cursors[depth] = cursors[depth] + 1
                return true
            }

            if (hasNext(list[cursors[depth]].getList(), depth + 1)) {
                return true
            }

            cursors[depth]++
        }

        cursors.removeAt(depth)
        return false
    }
}