package edu.sliding;

import java.util.HashMap;

class CharacterReplacement {
    public static int findLength(String str, int k) {

        int windowStart = 0;
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        int longestLength = Integer.MIN_VALUE;
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char endChar = str.charAt(windowEnd);
            frequencyMap.put(endChar, frequencyMap.getOrDefault(endChar, 0) + 1);

            if (windowEnd - windowStart + 1 - frequencyMap.get(endChar) > k) {
                char startChar = str.charAt(windowStart++);
                frequencyMap.put(startChar, frequencyMap.get(startChar) - 1);
            }

            longestLength = Math.max(longestLength, windowEnd - windowStart + 1);

        }

        return longestLength;
    }

    public static void main(String[] args) {
        //5
        System.out.println(CharacterReplacement.findLength("aabccbb", 2));
        //4
        System.out.println(CharacterReplacement.findLength("abbcb", 1));
        //3
        System.out.println(CharacterReplacement.findLength("abccde", 1));
    }
}