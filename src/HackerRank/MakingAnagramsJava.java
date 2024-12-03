package HackerRank;

import java.util.HashMap;

public class MakingAnagramsJava {
    public static int makeAnagram(String a, String b) {
        // Write your code here
        //create a HashMap to store the strings
        HashMap<Character, Integer> charCount = new HashMap<>();
        for(char c : a.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        for(char c : b.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) -1);
        }

        int deletions = 0;
        for(int i : charCount.values()) {
            deletions += Math.abs(i);
        }
        return deletions;
    }
}
