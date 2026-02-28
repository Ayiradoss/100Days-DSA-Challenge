package dailychallenge.Day13;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] nums = {{1,3},{2,6},{8,10},{15,18}};

        System.out.print(Arrays.deepToString(merge(nums)));
    }
    public static int[][] merge(int[][] arr) {

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        int index = 0;

        List<int[]> list = new LinkedList<>();

        while(index < arr.length)
        {
            int start = arr[index][0];

            int end = arr[index][1];

            while(index < arr.length-1 && end >= arr[index + 1][0])
            {
                end = Math.max(end, arr[index + 1][1]);

                index++;
            }
            list.add(new int[] {start, end});

            index++;
        }
        return list.toArray(new int[list.size()][]);
    }
}
