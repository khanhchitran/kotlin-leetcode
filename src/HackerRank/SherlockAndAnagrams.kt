package HackerRank

class SherlockAndAnagrams {
    fun sherlockAndAnagrams(s: String): Int {
        // Write your code here
        val stringMap = mutableMapOf<String, Int>()
        for (i in 0..s.length) {
            for (j in i + 1..s.length) {
                val subString = s.substring(i, j).toCharArray().sorted().joinToString("")
                stringMap[subString] = stringMap.getOrDefault(subString, 0) + 1
            }
        }
        var count = 0
        for (str in stringMap.values) {
            count += str * (str - 1) / 2
        }
        return count
    }
}
