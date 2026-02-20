package dailychallenge.Day5;

import java.util.Arrays;

public class FindPairDifference {
    public static void main(String[] args) {
        int[] arr = {5, 20, 3, 2, 5, 80};

        int x = 78;

        System.out.print(findPair(arr,x));
    }
    public static boolean findPair(int[] arr, int x) {
        Arrays.sort(arr);

        int left = 0;

        int rigth = 1;

        while(left < arr.length && rigth < arr.length)
        {
            if(left == rigth)
            {
                rigth++;

                continue;
            }

            int diff = arr[rigth] - arr[left];

            if(left != rigth && diff == x)
            {
                return true;
            }
            else if(diff < x)
            {
                rigth++;
            }
            else
            {
                left++;
            }
        }
        return false;
    }
}
