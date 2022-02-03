package pro88

// https://leetcode.com/problems/merge-sorted-array/

// 참고 https://leetcode.com/problems/merge-sorted-array/discuss/1669211/Kotlin-2-pointer-Lopp
class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var p1 = m - 1
        var p2 = n - 1

        for(i in (m+n-1) downTo 0) {
            nums1[i] = when {
                (p2 >= 0 && p1 >= 0 && nums1[p1] >= nums2[p2]) -> nums1[p1--]
                (p2 >= 0 && p1 >= 0 && nums1[p1] <= nums2[p2]) -> nums2[p2--]
                (p2 >= 0 && p1 < 0) -> nums2[p2--]
                (p2 < 0 && p1 >= 0) -> nums1[p1--]
                else -> 0
            }
        }
    }
}