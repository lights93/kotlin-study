package pro703

class KthLargest(k: Int, nums: IntArray) {
    var list = nums.toMutableList()
    val limit = k

    fun add(`val`: Int): Int {
        list.add(`val`)
        list = list.sortedDescending().take(limit).toMutableList()

        if (list.size >= limit) {
            return list[limit - 1]
        }
        return list[0]
    }

}

/**
 * Your KthLargest object will be instantiated and called as such:
 * var obj = KthLargest(k, nums)
 * var param_1 = obj.add(`val`)
 */