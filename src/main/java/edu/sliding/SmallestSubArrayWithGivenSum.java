package edu.sliding;

public class SmallestSubArrayWithGivenSum {

    //easy

    public static int findMinSubArray(int sum, int[] arr) {
        int size = arr.length;
        int localTotal = 0;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            localTotal += arr[windowEnd];

            while (localTotal > sum) {
                localTotal -= arr[windowStart++];
                if (size > (windowEnd - windowStart + 1)) {
                    size = windowEnd - windowStart + 1;
                }
            }


        }

        return size;
    }


    public static void main(String[] args) {
        int[] input = new int[]{2, 1, 5, 2, 3, 2};
        int sum = 7;

        //2
        int result = findMinSubArray(sum, input);
        System.out.println("result = " + result);

    }
}
