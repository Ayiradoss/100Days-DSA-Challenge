package dailychallenge.Day2;

import java.util.ArrayDeque;
import java.util.Arrays;

public class slidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};

        int k = 3;

        System.out.print(Arrays.toString(maxSlidingWindow(nums, k)));
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {

        int[] res = new int[nums.length - k + 1];

        ArrayDeque<Integer> dq = new ArrayDeque<>();

        int start = 0;

        int s = 0;

        for(int end = 0; end<nums.length; end++)
        {
            while(!dq.isEmpty() && nums[end] >= nums[dq.peekLast()])
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

            res[s++] = nums[dq.peekFirst()];

            start++;
        }
        return res;
    }
}