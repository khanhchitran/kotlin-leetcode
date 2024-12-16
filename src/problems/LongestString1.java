package problems;

import java.util.HashMap;

public class LongestString1 {
    public int longestString(String s) {
        HashMap<Character,Integer> seenChars = new HashMap<>();
        int maxLength = 0;
        int start = 0;
        for(int end = 0; end < s.length();end++){
            char currentChar = s.charAt(end);
            if(seenChars.containsKey(currentChar) && seenChars.get(currentChar) >= start){
                start = seenChars.get(currentChar) + 1;
            }
            seenChars.put( currentChar, end);
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}
