package dailychallenge.Day2;

import java.util.ArrayDeque;
import java.util.Arrays;

public class slidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};

        int k = 3;

        maxSlidingWindow(nums, k);
    }
    public static void maxSlidingWindow(int[] nums, int k) {

        if(nums.length < k)
        {
            System.out.print(-1);
            return;
        }

        ArrayDeque<Integer> dq = new ArrayDeque<>();

        int start = 0;

        for(int end = 0; end < nums.length; end++)
        {
            while (!dq.isEmpty() && nums[end] >= nums[dq.peekLast()])
            {
                dq.pollLast();
            }
            dq.addLast(end);

            int windowSize = end - start + 1;

            if(windowSize < k)
            {
                continue;
            }

            if(dq.peekFirst() < start)
            {
                dq.pollFirst();
            }

            System.out.print(nums[dq.peekFirst()]+", ");
            start++;
        }
    }
}