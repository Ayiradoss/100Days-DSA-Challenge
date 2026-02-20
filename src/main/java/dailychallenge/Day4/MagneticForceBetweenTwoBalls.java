package dailychallenge.Day4;

import java.util.Arrays;

public class MagneticForceBetweenTwoBalls {
    public static void main(String[] args) {
        int[] position = {1,2,3,4,7};

        int k = 3;

        System.out.print(maxDistance(position, k));
    }
    public static int maxDistance(int[] position, int k) {

        Arrays.sort(position);

        int left = 1;

        int rigth = position[position.length-1] - position[0];

        int res = 0;

        while(left <= rigth)
        {
            int mid = left + (rigth - left) / 2;

            if(lessOrMore(position, k, mid))
            {
                left = mid + 1;

                res = mid;
            }
            else
            {
                rigth = mid - 1;
            }
        }
        return res;
    }
    private static boolean lessOrMore(int[] position, int k, int target)
    {
        int count = 1;

        int lastPos = position[0];

        for(int i = 1; i < position.length; i++)
        {
            if(position[i] - lastPos >= target)
            {
                count++;

                lastPos = position[i];
            }
        }
        return count >= k;
    }
}