// https://leetcode.com/problems/contains-duplicate/
package pro217

class Solution {
    fun containsDuplicate(nums: IntArray): Boolean = nums.size != nums.toSet().size
}