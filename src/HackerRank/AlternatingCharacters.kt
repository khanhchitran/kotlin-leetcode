package HackerRank

class AlternatingCharacters {
    fun alternatingCharaters(s : String) : Int {
        var deletions = 0
       for (i in 0 until s.length - 1){
           if (s[i] == s[i+1]){
               deletions++
           }
       }
        return deletions
    }
}
