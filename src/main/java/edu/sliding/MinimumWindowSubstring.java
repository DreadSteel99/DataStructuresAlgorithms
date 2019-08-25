package edu.sliding;

import java.util.*;

class MinimumWindowSubstring {
    public static String findPermutation(String str, String pattern) {
        int minLength = Integer.MAX_VALUE;
        HashMap<Character, Integer> patMap = new HashMap<>();
        int windowStart = 0;
        int stringStart = 0;
        int stringEnd = 0;
        int matched = 0;

        for (char c : pattern.toCharArray()) {
            patMap.put(c, patMap.getOrDefault(c, 0) + 1);
        }

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char endChar = str.charAt(windowEnd);
            if (patMap.containsKey(endChar)) {
                patMap.put(endChar, patMap.get(endChar) - 1);

                if (patMap.get(endChar) == 0) {
                    matched++;
                }
            }

            while (matched == patMap.size()) {
                if (minLength > windowEnd - windowStart + 1) {
                    stringStart = windowStart;
                    minLength = windowEnd - windowStart + 1;
                }

                char startChar = str.charAt(windowStart++);
                if (patMap.containsKey(startChar)) {
                    if (patMap.get(startChar) == 0) {
                        matched--;
                    }
                    patMap.put(startChar, patMap.get(startChar) + 1);
                }
            }
        }

        return minLength > str.length() ? "" : str.substring(stringStart, stringStart + minLength); //Nice one
    }

    public static void main(String[] args) {
        System.out.println(MinimumWindowSubstring.findPermutation("aabdec", "abc")); //Output: "abdec"
        System.out.println(MinimumWindowSubstring.findPermutation("abdabca", "abc")); //Output: "abc"
        System.out.println(MinimumWindowSubstring.findPermutation("adcad", "abc")); //Output: ""
    }
}