package dailychallenge.Day9;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] arr = {2,3,5,4,1};

        int target = 5;

        List<Integer> list = new ArrayList<>();

        bt(arr, target, 0, list);
    }

    private static void bt(int[] arr, int target, int index, List<Integer> list)
    {
        if(target == 0)
        {
            System.out.println(list);
        }
        if(target < 0)
        {
            return;
        }
        for(int i = index; i < arr.length; i++)
        {
            list.add(arr[i]);

            bt(arr, target - arr[i], index, list);

            list.remove(list.size()-1);
        }
    }
}
