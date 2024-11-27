package HackerRank
/**
Harold is a kidnapper who wrote a ransom note, but now he is worried it will be traced back to him through his handwriting. He found a magazine and wants to know if he can cut out whole words from it and use them to create an untraceable replica of his ransom note. The words in his note are case-sensitive and he must use only whole words available in the magazine. He cannot use substrings or concatenation to create the words he needs.

Given the words in the magazine and the words in the ransom note, print Yes if he can replicate his ransom note exactly using whole words from the magazine; otherwise, print No.

Example
 "attack at dawn" and "Attack at dawn"

The magazine has all the right words, but there is a case mismatch. The answer is .

Function Description

Complete the checkMagazine function in the editor below. It must print  if the note can be formed using the magazine, or .

checkMagazine has the following parameters:

string magazine[m]: the words in the magazine
string note[n]: the words in the ransom note
**/

class RansomNote {
    /** Brutal force:
     * This solution is functional, but it has some inefficiencies. Specifically,
     * the use of Array.contains inside the loop results in a time complexity of O(n.m)
     * n: size of note array
     * m: size of magazine array
     */
    fun checkMagazine(magazine: Array<String>, note: Array<String>) {
        //create a mutable list from magazine array
        val magazineList = magazine.toMutableList()
        // Iterate through the note array
        for (word in note) {
            // If the word is not found or there's no occurrences left
            if (!magazineList.remove(word)) {
                println("No")
                return
            }
        }
        // If all words in the note are found in the magazine
        println("Yes")
    }
    /**
     * More efficient approach:
     * Use Map or HashMap to track the count of each word in the magazine
     * Result time complexity of O(n + m)
     */
    fun checkMagazine2(magazine: Array<String>, note: Array<String>) {
      // Create a map to count occurrences of each word in magazine
        val wordCountMap = mutableMapOf<String, Int>()
      // Iterate through magazine
      for(word in magazine){
          // Populate map with magazine words
          wordCountMap[word] = wordCountMap.getOrDefault(word, 0) + 1
      }
      // Iterate through note
      for (word in note){
          // Check if all words in note can be found in magazine
          val count = wordCountMap.getOrDefault(word, 0)
          if (count == 0) {
              println("No")
              return
          }
         // If the word found, decrease the count of word
          wordCountMap[word] = count - 1
      }
        println("Yes")
    }
}
