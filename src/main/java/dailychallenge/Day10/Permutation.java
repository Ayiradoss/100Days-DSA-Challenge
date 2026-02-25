package dailychallenge.Day10;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {
        int[] nums = {1,2,3};

        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums)
    {
        List<List<Integer>> list = new ArrayList<>();

        boolean[] used = new boolean[nums.length];

        bt(list, new ArrayList<>(), nums, used);

        return list;
    }
    public static void bt(List<List<Integer>> list, List<Integer> tempList, int[] nums, boolean[] used)
    {
        if(tempList.size() == nums.length)
        {
            list.add(new ArrayList<>(tempList));

            return;
        }

        for(int i = 0; i<nums.length; i++)
        {
            if(used[i])
            {
                continue;
            }

            used[i] = true;

            tempList.add(nums[i]);

            bt(list, tempList, nums, used);

            tempList.remove(tempList.size() - 1);

            used[i] = false;
        }
    }
}
