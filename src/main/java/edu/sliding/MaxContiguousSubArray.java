package edu.sliding;

public class MaxContiguousSubArray {

    public static int findMaxSumSubArray(int k, int[] arr) {

        int maxSumUntilNow = 0;
        int windowSum = 0;

        for (int i = 0; i < arr.length; i++) {
            windowSum += arr[i];

            if (i + 1 >= k) {
                if (maxSumUntilNow < windowSum) {
                    maxSumUntilNow = windowSum;
                }
                windowSum -= arr[i + 1 - k];
            }
        }
        return maxSumUntilNow;

    }

    public static void main(String[] args) {
        int[] input = new int[]{2, 1, 5, 1, 3, 2};
        int k = 3;

        int result = findMaxSumSubArray(k, input);
        System.out.println("result = " + result); //9
    }

}
