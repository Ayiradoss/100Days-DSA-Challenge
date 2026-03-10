package dailychallenge.Day20;

import java.util.Arrays;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = {0,3,7,2,5,8,4,6,0,1};

        System.out.print(longestConsecutive(nums));
    }
    public static int longestConsecutive(int[] nums) {
        if(nums.length == 0)
        {
            return 0;
        }

        Arrays.sort(nums);

        int maxLen = 1;

        int currentLen = 1;

        for(int i = 1; i < nums.length; i++)
        {
            if(nums[i] == nums[i-1])
            {
                continue;
            }
            else if(nums[i] == nums[i-1] + 1)
            {
                currentLen++;
            }
            else
            {
                maxLen = Math.max(maxLen, currentLen);

                currentLen = 1;
            }
        }

        return Math.max(maxLen, currentLen);
    }
}
