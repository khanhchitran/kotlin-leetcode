package problems

/**
 * Given a string s, find the length of the longest
 * substring
 *  without repeating characters.
 *
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 */
class LongestString {
    fun lengthOfLongestSubstring(s: String) : Int{
        var maxLength = 0
        var start = 0
        val seenChars = mutableMapOf<Char, Int>()
        for(end in s.indices){
            val currentChar = s[end]
            if (seenChars.containsKey(currentChar) && seenChars[currentChar]!! >= start){
                start = seenChars[currentChar]!! + 1
            }
            seenChars[currentChar] = end
            maxLength = maxOf(maxLength, end - start + 1)
        }
        return maxLength
    }
}
