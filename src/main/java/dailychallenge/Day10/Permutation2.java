package dailychallenge.Day10;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutation2 {
    public static void main(String[] args) {
        int[] nums = {1,1,2};

        System.out.println(permuteUnique(nums));
    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> list = new HashSet<>();

        boolean[] used = new boolean[nums.length];

        bt(list, new ArrayList<>(), nums, used);

        return new ArrayList<>(list);
    }
    public static void bt(Set<List<Integer>> list, List<Integer> tempList, int[] nums, boolean[] used)
    {
        if(tempList.size() == nums.length)
        {
            if(list.contains(tempList))
            {
                return;
            }
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
