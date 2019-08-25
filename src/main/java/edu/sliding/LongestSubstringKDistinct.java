package edu.sliding;

import java.util.*;

//medium
class LongestSubstringKDistinct {
    public static int findLength(String str, int k) {

        int longestSoFar = Integer.MIN_VALUE;
        int windowStart = 0;
        HashMap<Character, Integer> frequency = new HashMap<>();


        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char curr = str.charAt(windowEnd);
            frequency.put(curr, frequency.getOrDefault(curr, 0) + 1);

            while (frequency.size() > k) {
                char startChar = str.charAt(windowStart++);
                int startCharCount = frequency.get(startChar);
                frequency.put(startChar, startCharCount - 1);
                if (frequency.get(startChar) == 0)
                    frequency.remove(startChar);
            }

            longestSoFar=Math.max(longestSoFar, (windowEnd-windowStart+1));

        }

        return longestSoFar;
    }

    public static void main(String[] args) {
        //4 - Explanation: The longest substring with no more than '2' distinct characters is "araa".
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 2));
        //2 - Explanation: The longest substring with no more than '1' distinct characters is "aa".
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 1));
        //5 - Explanation: The longest substrings with no more than '3' distinct characters are "cbbeb" & "bbebi".
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("cbbebi", 3));
    }
}