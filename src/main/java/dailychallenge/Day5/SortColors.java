package dailychallenge.Day5;

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};

        sortColors(nums);
    }
    public static void sortColors(int[] nums) {
        int left = 0;

        int rigth = nums.length-1;

        int mid = 0;

        while(mid <= rigth)
        {
            switch(nums[mid])
            {
                case 0:

                    swap(left, mid, nums);

                    left++;

                    mid++;

                    break;

                case 1:

                    mid++;

                    break;

                case 2:

                    swap(rigth, mid, nums);

                    rigth--;

                    break;
            }
        }
        System.out.print(Arrays.toString(nums));
    }
    public static void swap(int i, int j, int[] nums)
    {
        int temp = nums[i];

        nums[i] = nums[j];

        nums[j] = temp;
    }
}
