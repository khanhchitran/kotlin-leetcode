package HackerRank;

import java.util.HashSet;
import java.util.Set;

public class TwoStringJava {
    public static String twoStrings(String s1, String s2) {
        // Create a Set to store unique characters from the first string
        Set<Character> charSet = new HashSet<>();

        // Add all characters of s1 to the set
        for (char c : s1.toCharArray()) {
            charSet.add(c);
        }

        // Check if any character of s2 exists in the set
        for (char c : s2.toCharArray()) {
            if (charSet.contains(c)) {
                return "YES"; // Common character found
            }
        }

        return "NO"; // No common characters
    }
}
