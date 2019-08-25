package edu.sliding;

import java.util.*;

class MaxFruitCountOf2Types {

    public static int findLength(char[] arr) {
        int windowStart = 0;
        int K = 2;
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        int longestStrCount = Integer.MIN_VALUE;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            char eachChar = arr[windowEnd];
            frequencyMap.put(eachChar, frequencyMap.getOrDefault(arr[windowEnd], 0) + 1);

            while (frequencyMap.size() > K) {
                char startChar = arr[windowStart];
                frequencyMap.put(startChar, frequencyMap.getOrDefault(startChar, 0) - 1);
                if (frequencyMap.get(startChar) == 0) {
                    frequencyMap.remove(startChar);
                }
                windowStart++;
            }
            longestStrCount = Math.max(longestStrCount, (windowEnd - windowStart + 1));
        }
        return longestStrCount;
    }

    public static void main(String[] args) {
        //3
        System.out.println("Maximum number of fruits: " +
                MaxFruitCountOf2Types.findLength(new char[]{'A', 'B', 'C', 'A', 'C'}));
        //5
        System.out.println("Maximum number of fruits: " +
                MaxFruitCountOf2Types.findLength(new char[]{'A', 'B', 'C', 'B', 'B', 'C'}));
    }
}
