package dailychallenge.Day1;

public class MaxSumSubarrayOfSizeK {
    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 10, 23, 3, 1, 0, 20};

        int k = 4;

        System.out.print(maxSubarraySum(arr, k));
    }
    public static int maxSubarraySum(int[] arr, int k) {

        if(arr.length < k)
        {
            return -1;
        }

        int maxSum = Integer.MIN_VALUE;

        int sum = 0;

        int start = 0;

        for(int end = 0; end < arr.length; end++)
        {
            sum += arr[end];

            int windowSize = end - start + 1;

            if(windowSize == k)
            {
                maxSum = Math.max(sum, maxSum);

                sum -= arr[start];

                start++;
            }
        }
        return maxSum;
    }
}
