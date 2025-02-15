package edu.sliding;

class ReplacingOnes {
    public static int findLength(int[] arr, int k) {
        int maxOnesCount = 0;
        int windowStart = 0;
        int maxLengthCount = Integer.MIN_VALUE;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            if (arr[windowEnd] == 1) maxOnesCount++;

            if (windowEnd - windowStart + 1 - maxOnesCount > k) {
                if (arr[windowStart]==1){
                    maxOnesCount--;
                }
                windowStart++;

            }
            maxLengthCount = Math.max(maxLengthCount, windowEnd - windowStart + 1);
        }


        return maxLengthCount;
    }

    public static void main(String[] args) {
        System.out.println(ReplacingOnes.findLength(new int[] { 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1 }, 2)); //6
        System.out.println(ReplacingOnes.findLength(new int[] { 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1 }, 3)); //9
    }
}
