package dailychallenge.Day1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FirstNegativeInEveryWindowOfSizeK {
    public static void main(String[] args) {
        int[] arr = {-8, 2, 3, -6, 10};

        int k = 2;

        System.out.print(firstNegInt(arr, k));
    }
    public static List<Integer> firstNegInt(int arr[], int k) {

        if(arr.length < k)
        {
            return new ArrayList<>();
        }

        Queue<Integer> qu = new LinkedList<>();

        List<Integer> list = new ArrayList<>();

        int start = 0;

        for(int end = 0; end < arr.length; end++)
        {
            if(arr[end] < 0)
            {
                qu.add(end);
            }

            int windowSize = end - start + 1;

            if(windowSize < k)
            {
                continue;
            }

            if(windowSize == k)
            {

                if(qu.isEmpty())
                {
                   list.add(0);
                }
                else
                {
                    list.add(arr[qu.peek()]);
                }
                if(!qu.isEmpty() && qu.peek() == start)
                {
                    qu.poll();
                }
                start++;
            }
        }
        return list;
    }
}
