package HackerRank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class SherlockAndAnagramsJava {
    public static int sherlockAndAnagrams(String s) {
        // Create a HashMap to store the substrings
        HashMap<String, Integer> substringMap = new HashMap<>();
        // Iterate through s string
        for(int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                // Generate all the possible substrings
                String substring = s.substring(i, j);
                // sort the substrings
                char[] chars = substring.toCharArray();
                Arrays.sort(chars);
                String sortedString = new String(chars);
                // Update substring map
                substringMap.put(sortedString, substringMap.getOrDefault(sortedString,0) + 1);
            }
        }
        int count = 0;
        // Count anagrammatic pairs
        for(int frequency :substringMap.values()){
            count += (frequency * (frequency - 1)) / 2 ;
        }
        return count;
    }
}
