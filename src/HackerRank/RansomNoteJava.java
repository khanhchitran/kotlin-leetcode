package HackerRank;

import java.util.HashMap;
import java.util.List;

public class RansomNoteJava {
    public static void checkMagazine(String[] magazine, String[] note) {
        HashMap<String, Integer> wordCountMap = new HashMap<>();
        for (String word : magazine) {
          wordCountMap.put(word, wordCountMap.getOrDefault(word,0) + 1);
        }

        for(String word : note) {
            if(!wordCountMap.containsKey(word) || wordCountMap.get(word) <= 0) {
                System.out.println("No");
                return;
            }
            wordCountMap.put(word, wordCountMap.get(word) - 1);
        }
        System.out.println("Yes");
    };
    public static void main(String[] args) {
        // Example test cases
        String[] magazine1 = {"two", "times", "three", "is", "not", "four", "two"};
        String[] note1 = {"two", "times", "two", "is", "four"};
        checkMagazine(magazine1, note1); // Output: Yes

        String[] magazine2 = {"two", "times", "three", "is", "not", "four"};
        String[] note2 = {"two", "times", "two", "is", "four"};
        checkMagazine(magazine2, note2); // Output: No
    };
};
