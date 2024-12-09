package HackerRank

class MinimumSwap2 {
    fun minimumSwaps(arr: Array<Int>) : Int{
        var swaps = 0
        val n = arr.size
        var visited = BooleanArray(n)

        for (i in arr.indices){
            // If already visited or in the correct position, skip
            if (visited[i] || arr[i] == i + 1) continue
            // Find the cycle size
            var cycleSize = 0
            var j = i
            while (!visited[j]) {
                visited[j] = true
                j = arr[j] - 1 // Move to the next index in the cycle
                cycleSize++
            }
            // Add the swaps needed for this cycle
            if (cycleSize > 1) {
                swaps += cycleSize - 1
            }
        }
        return swaps
    }
}
