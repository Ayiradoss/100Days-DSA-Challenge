package dailychallenge.Day4;

import java.util.Arrays;

public class MagneticForceBetweenTwoBalls {
    public static void main(String[] args) {
        int[] position = {1,2,3,4,7};

        int k = 3;

        System.out.print(maxDistance(position, k));
    }
    public static int maxDistance(int[] position, int m) {

        Arrays.sort(position);

        int low = 1;

        int high = position[position.length-1] - position[0];

        int res = 0;

        while(low <= high)
        {
            int mid = (low + high) / 2;

            if(isSafe(position, m, mid))
            {
                low = mid + 1;

                res = mid;
            }
            else
            {
                high = mid - 1;
            }
        }
        return res;
    }
    private static boolean isSafe(int[] nums, int k, int mid)
    {
        int count = 1;

        int lastPos = nums[0];

        for(int i = 1; i < nums.length; i++)
        {
            if(nums[i] - lastPos >= mid)
            {
                count++;

                lastPos = nums[i];
            }
        }
        return count >= k;
    }
}
