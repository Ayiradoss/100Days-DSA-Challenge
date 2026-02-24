package dailychallenge.Day9;

import java.util.ArrayList;
import java.util.List;

public class SubSets {
    public static void main(String[] args) {
        int[] arr = {1,2,3};

        List<Integer> list = new ArrayList<>();

        bt(arr, 0, list);
    }
    private static void bt(int[] arr, int index, List<Integer> list)
    {
        System.out.println(list);

        for(int i = index; i < arr.length; i++)
        {
            list.add(arr[i]);

            bt(arr, i + 1, list);

            list.remove(list.size() - 1);
        }
    }
}
