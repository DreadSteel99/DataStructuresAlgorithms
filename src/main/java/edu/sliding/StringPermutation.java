package edu.sliding;

import java.util.*;

class StringPermutation {
    public static boolean findPermutation(String str, String pattern) {

        int windowStart = 0;
        HashMap<Character, Integer> patMap = new HashMap<>();
        int matched = 0;

        for (int i = 0; i < pattern.length(); i++) {
            patMap.put(pattern.charAt(i), patMap.getOrDefault(pattern.charAt(i), 0) + 1);
        }

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char endChar = str.charAt(windowEnd);

            if (patMap.containsKey(endChar)) {
                patMap.put(endChar, patMap.get(endChar) - 1);
                if (patMap.get(endChar) == 0) {
                    matched++;
                }
            }

            if (matched == patMap.size()) {
                return true;
            }

            if (windowEnd - windowStart >= pattern.length() - 1) {
                char startChar = str.charAt(windowStart++);
                if (patMap.containsKey(startChar)) {
                    if (patMap.get(startChar) == 0) {
                        matched--;
                    }
                    patMap.put(startChar, patMap.get(startChar) + 1);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("Permutation exist: " + StringPermutation.findPermutation("oidbcaf", "abc")); //true
        System.out.println("Permutation exist: " + StringPermutation.findPermutation("odicf", "dc")); //false
        System.out.println("Permutation exist: " + StringPermutation.findPermutation("bcdxabcdy", "bcdyabcdx")); //true
        System.out.println("Permutation exist: " + StringPermutation.findPermutation("aaacb", "abc")); //true
    }
}
