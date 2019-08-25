package edu.sliding;

import java.util.*;

class StringAnagrams {
    public static List<Integer> findStringAnagrams(String str, String pattern) {
        List<Integer> resultIndices = new ArrayList<Integer>();
        HashMap<Character, Integer> patMap = new HashMap<>();

        for (char p : pattern.toCharArray()) {
            patMap.put(p, patMap.getOrDefault(p, 0) + 1);
        }

        int windowStart = 0;
        int matched = 0;
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char endChar = str.charAt(windowEnd);

            if (patMap.containsKey(endChar)) {
                patMap.put(endChar, patMap.get(endChar) - 1);
                if (patMap.get(endChar) == 0) {
                    matched++;
                }
            }

            if (matched == patMap.size()) {
                resultIndices.add(windowStart);
            }

            if (windowEnd >= pattern.length() - 1) {
                char startChar = str.charAt(windowStart++);
                if (patMap.containsKey(startChar)) {
                    if (patMap.get(startChar) == 0) {
                        matched--;
                    }
                    patMap.put(startChar, patMap.get(startChar) + 1);
                }
            }
        }

        return resultIndices;
    }

    public static void main(String[] args) {
        System.out.println(StringAnagrams.findStringAnagrams("ppqp", "pq")); //Output: [1, 2]
        System.out.println(StringAnagrams.findStringAnagrams("abbcabc", "abc")); //Output: [2, 3, 4]
    }
}
