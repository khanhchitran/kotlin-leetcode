package problems

class TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray{
        val numMap = mutableMapOf<Int,Int>()
        for (i in nums.indices){
            val complement = target - nums[i]
            if(numMap.containsKey(complement)){
                return intArrayOf(numMap[complement]!!, i)
            }
            numMap[nums[i]] = i
        }
        throw IllegalArgumentException("No Two Sum Solution")
    }
}
