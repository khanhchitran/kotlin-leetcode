package HackerRank

class MakingAnagrams {
    fun makeAnagram(a: String, b: String): Int {
        // Write your code here
        var charCount = mutableMapOf<Char, Int>()
        for(c in a.toCharArray()) {
            charCount[c] = charCount.getOrDefault(c, 0) + 1
        }

        for(c in b.toCharArray()) {
            charCount[c] = charCount.getOrDefault(c, 0) - 1
        }

        var deletions = 0
        for(i in charCount.values) {
            deletions += Math.abs(i)
        }

        return deletions
    }
}
