package HackerRank

class TwoString {
    fun twoStrings(s1: String, s2: String): String {
        // Write your code here
        val charSet = mutableSetOf<Char>()
        for(c in s1) {
            charSet.add(c)
        }
        for(c in s2) {
            if(charSet.contains(c)){
                return "YES"
            }
        }
        return "NO"
    }

}
