package dailychallenge.Day10;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum2 {
    public static void main(String[] args) {
        int[] nums = {10,1,2,7,6,1,5};

        int target = 8;

        System.out.print(combinationSum2(nums, target));
    }
    public static List<List<Integer>> combinationSum2(int[] nums, int target) {
        sort(nums);

        List<List<Integer>> list = new ArrayList<>();

        bt(list, nums, target, new ArrayList<>(), 0);

        return list;
    }
    private static void bt(List<List<Integer>> list, int[] nums, int target, List<Integer> tempList, int start)
    {
        if(target == 0)
        {
            list.add(new ArrayList<>(tempList));
        }
        if(target < 0)
        {
            return;
        }

        for(int i = start; i<nums.length; i++)
        {
            if(i > start && nums[i] == nums[i-1])
            {
                continue;
            }
            tempList.add(nums[i]);

            bt(list, nums, target - nums[i], tempList, i+1);

            tempList.remove(tempList.size() - 1);
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
