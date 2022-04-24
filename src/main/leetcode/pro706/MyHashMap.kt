package pro706

// https://leetcode.com/problems/design-hashmap/
class MyHashMap() {
    private var buckets = Array<MutableList<Entry>>(INITIAL_CAPACITY) { mutableListOf() }
    private var threshold = INITIAL_CAPACITY * LOAD_FACTOR
    private var count = 0

    fun put(key: Int, value: Int) {
        val entry = getEntry(key)
        if(entry == null) {
            count++
            if (count >= threshold) {
                resize()
            }
            buckets[index(key)].add(Entry(key, value))
        } else {
            entry.value = value
        }
    }

    private fun getEntry(key: Int): Entry? {
        return buckets[index(key)].firstOrNull { it.key == key }
    }

    fun get(key: Int): Int {
        return getEntry(key)?.value ?: -1
    }

    fun remove(key: Int) {
        val entry = getEntry(key)
        if(entry != null) {
            buckets[index(key)].removeAt(buckets[index(key)].indexOfFirst { it.key == key })
            count--
        }
    }

    private fun index(key: Int): Int {
        return Math.abs(key.hashCode()) % buckets.size
    }

    fun resize() {
        val newBuckets = Array<MutableList<Entry>>(buckets.size * 2) { mutableListOf() }

        buckets.forEach { list ->
            list.forEach { entry ->
                newBuckets[entry.key.hashCode() % newBuckets.size].add(entry)
            }
        }

        buckets = newBuckets
        threshold = buckets.size * LOAD_FACTOR
    }


    private class Entry(val key: Int, var value: Int)

    companion object {
        const val INITIAL_CAPACITY = 16
        const val LOAD_FACTOR = 0.75
    }
}
/**
 * Your MyHashMap object will be instantiated and called as such:
 * var obj = MyHashMap()
 * obj.put(key,value)
 * var param_2 = obj.get(key)
 * obj.remove(key)
 */