package dailychallenge.Day1;

import java.util.ArrayDeque;

public class FirstMaximumElementInEveryWindowOfSizeK {
    public static void main(String[] args) {
        int[] arr = { 1,3,5,2,1,8,6,9 };

        int k = 3;

        findFirstMax(arr, k);
    }
    public static void findFirstMax(int[] arr, int k)
    {
        if(arr.length < k)
        {
            System.out.print(-1);

            return;
        }
        ArrayDeque<Integer> dq = new ArrayDeque<>();

        int start = 0;

        System.out.print("[");
        for(int end = 0; end<arr.length; end++)
        {
            while (!dq.isEmpty() && arr[end] >= arr[dq.peekLast()])
            {
                dq.pollLast();
            }
            dq.addLast(end);

            int windowSize = end - start + 1;

            if (windowSize < k)
            {
                continue;
            }
            if (dq.peekFirst() < start)
            {
                dq.pollFirst();
            }
            System.out.print(arr[dq.peekFirst()] + ", ");

            start++;
        }
        System.out.print("]");
    }
}
