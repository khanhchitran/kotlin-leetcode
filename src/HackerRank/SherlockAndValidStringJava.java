package HackerRank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SherlockAndValidStringJava {
    /*
     * Complete the 'isValid' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isValid(String s) {
        // Write your code here
        /*
        2 valid cases:
        1/ all the frequences of characters are the same: abc, aabbcc, abcdefgh
        2/ all the frequences of characters are the same and only 1 character has frequency is more or less 1: aabbccd or aabbccddd so d can be removed
         */
        Map<Character, Integer> charCount = new HashMap<>();
        for(char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        Map<Integer, Integer> freqCount = new HashMap<>();

        for (int freq : charCount.values()) {
            freqCount.put(freq, freqCount.getOrDefault(freq, 0) + 1);
        }

        if (freqCount.size() == 1) {
            // All characters occur the same number of times
            return "YES";
        } else if (freqCount.size() == 2) {
            // There are two different frequencies
            List<Integer> frequencies = new ArrayList<>(freqCount.keySet());
            int freq1 = frequencies.get(0);
            int freq2 = frequencies.get(1);

            // Get the counts of each frequency
            int count1 = freqCount.get(freq1);
            int count2 = freqCount.get(freq2);

            // Check if one character can be removed
            if ((freq1 == 1 && count1 == 1) || (freq2 == 1 && count2 == 1)) {
                return "YES"; // Case where a single character can be removed
            }
            if (Math.abs(freq1 - freq2) == 1 && (count1 == 1 || count2 == 1)) {
                return "YES"; // Case where one frequency is exactly 1 more than the other
            }
        }

        return "NO"; // Cannot be made valid
    }
}
