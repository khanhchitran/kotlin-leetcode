package HackerRank

class SherlockAndValidString {
    fun isValid(s: String): String {
            // Write your code here

            val eachCount = s.groupingBy { it }.eachCount()
            // s = "aabbcc"-> {a = 2, b = 2, c = 2}
            val freqCounts = eachCount.values.groupingBy { it }.eachCount()
            //{a = 2, b = 2, c = 2} -> {2 = 3 }
            // If there's only one frequency, the string is valid
            if (freqCounts.size == 1) return "YES"

            // If there are exactly two frequencies, check if one adjustment can make them equal
            if (freqCounts.size == 2) {

            val (freq1, freq2) = freqCounts.keys.toList()
            val (count1, count2) = freqCounts.values.toList()

            // Case 1: One character occurs once and can be removed
            // {1 = 1, 2 = 3}
            if ((freq1 == 1 && count1 == 1) || (freq2 == 1 && count2 == 1)) return "YES"

            // Case 2: The difference between frequencies is 1, and one occurs exactly once
            // {2 = 3, 3 = 1}
            if (Math.abs(freq1 - freq2) == 1 && (count1 == 1 || count2 == 1)) return "YES"
        }
        // Otherwise, it's not valid
        return "NO"
    }

}
