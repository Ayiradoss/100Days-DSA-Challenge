package dailychallenge.Day25;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {4, -2, 5, 2};

        System.out.print(Arrays.toString(productExceptSelf(nums)));
    }
    public static int[] productExceptSelf(int[] nums) {
        int[] arr = new int[nums.length];

        arr[0] = 1;

        for(int i = 1; i<nums.length; i++)
        {
            arr[i] = arr[i-1] * nums[i-1];
        }
        int mul = 1;

        for(int i = arr.length-1; i>=0; i--)
        {
            arr[i] = arr[i] * mul;

            mul = mul * nums[i];
        }
        return arr;
    }
}
