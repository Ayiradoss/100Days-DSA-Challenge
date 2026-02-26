package dailychallenge.Day10;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum2 {
    public static void main(String[] args) {
        int[] nums = {10,1,2,7,6,1,5};

        int target = 8;

        sort(nums);

        List<Integer> list = new ArrayList<>();

        bt(list, nums, target,0);
    }
    private static void bt(List<Integer> list, int[] nums, int target, int start)
    {
        if(target == 0)
        {
            System.out.print(list+" ");
        }
        if(target < 0)
        {
            return;
        }
        for(int i = start; i< nums.length;i++)
        {
            if(i > start && nums[i] == nums[i-1])
            {
                continue;
            }
            list.add(nums[i]);

            bt(list, nums,target - nums[i], i+1);

            list.removeLast();
        }
    }
    private static void sort(int[] nums)
    {
        for(int i = 0; i<nums.length-1; i++)
        {
            for(int j = 0; j < nums.length - 1-i; j++)
            {
                if(nums[j] < nums[j +1])
                {
                    int temp = nums[j];

                    nums[j] = nums[j+1];

                    nums[j+1] = temp;
                }
            }
        }
    }
}
