package dailychallenge.Day2;

public class BinarySubarraysWithSum {
    public static void main(String[] args) {
        int[] nums = {1,0,1,0,1};

        int goal = 2;

        System.out.print(numSubarraysWithSum(nums, goal));
    }
    public static int numSubarraysWithSum(int[] nums, int goal) {

        return atMost(nums, goal) - atMost(nums, goal - 1);
    }
    private static int atMost(int[] nums, int k)
    {
        if(k < 0)
        {
            return 0;
        }
        int start = 0;

        int count = 0;

        int sum = 0;

        for(int end = 0; end < nums.length; end++)
        {
            sum += nums[end];

            while(sum > k)
            {
                sum -= nums[start];

                start++;
            }
            count += (end - start + 1);
        }
        return count;
    }
}
