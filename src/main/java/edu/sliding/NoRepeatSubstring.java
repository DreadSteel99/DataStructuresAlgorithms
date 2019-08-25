package edu.sliding;

import java.util.*;

class NoRepeatSubstring {
    public static int findLength(String str) {

        int windowStart = 0;
        HashMap<Character, Integer> freqMap = new HashMap<>();
        int longestStringLen = Integer.MIN_VALUE;

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char endChar = str.charAt(windowEnd);

            if (freqMap.containsKey(endChar)) {
                windowStart = Math.max(windowStart, freqMap.get(endChar) + 1);
            }

            freqMap.put(endChar, windowEnd);
            longestStringLen = Math.max(longestStringLen, (windowEnd - windowStart + 1));

        }

        return longestStringLen;
    }

    public static void main(String[] args) {
        //3
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("aabccbb"));
        //2
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abbbb"));
        //3
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abccde"));
    }
}