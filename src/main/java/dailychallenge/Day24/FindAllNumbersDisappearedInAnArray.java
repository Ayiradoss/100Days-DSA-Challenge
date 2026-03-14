package dailychallenge.Day24;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};

        System.out.print(findDisappearedNumbers(nums));
    }
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        boolean[] arr = new boolean[nums.length+1];

        List<Integer> li = new ArrayList<>();

        int k=0;

        int n = nums.length;

        for(int num: nums)
        {
            arr[num] = true;
        }

        for(int i =1; i<arr.length; i++)
        {
            if(!arr[i])
            {
                li.add(i);
            }
        }
        return li;
    }
}
