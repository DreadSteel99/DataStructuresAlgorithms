package edu.sliding;

public class SubArraySumWindow {

    //easy
    private static double[] findAverageOfSubArray(int[] input, int k) {
        double[] result = new double[input.length - k + 1];

        int windowSum = 0;
        int resultIndex = 0;

        for (int i = 0; i < input.length; i++) {
            windowSum += input[i];

            if (i + 1 >= k) {
                result[resultIndex++] = windowSum;
                windowSum = windowSum - input[(i+1) - k];
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] input = new int[]{1, 3, 2, 6, -1, 4, 1, 8, 2};
        int k = 5;

        //9
        double[] result = findAverageOfSubArray(input, k);
        for (double v : result) {
            System.out.print(v + ", ");
        }
    }
}
