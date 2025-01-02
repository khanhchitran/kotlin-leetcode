package problems

class RotateArray {
    fun rotate(nums: IntArray, k: Int): Unit{
        val n = nums.size
        val r = k % n

        val left = nums.sliceArray(n - r until n)
        val right = nums.sliceArray(0 until n - r)

        return println("$left + $right")
    }
}
