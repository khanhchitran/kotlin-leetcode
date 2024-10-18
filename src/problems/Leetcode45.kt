package problems

/**
 * You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
 *
 * Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:
 *
 * 0 <= j <= nums[i] and
 * i + j < n
 * Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 *
 * Input: nums = [2,3,0,1,4]
 * Output: 2
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 1000
 * It's guaranteed that you can reach nums[n - 1].
 */

class Leetcode45 {
    fun jump(nums: IntArray): Int {
        if (nums.size <= 1) return 0

        var jumps = 0
        var currentEnd = 0
        var farthest = 0

        for (i in 0 until nums.size - 1) {
            farthest = maxOf(farthest, i + nums[i])

            // If we have reached the end of the current jump range
            if (i == currentEnd) {
                jumps++
                currentEnd = farthest
                // If we've reached the last index, return the jump count
                if (currentEnd >= nums.size - 1) break
            }
        }

        return jumps
    }

    fun main() {
        val nums1 = intArrayOf(2, 3, 1, 1, 4)
        println(jump(nums1))  // Output: 2

        val nums2 = intArrayOf(2, 3, 0, 1, 4)
        println(jump(nums2))  // Output: 2
    }

}