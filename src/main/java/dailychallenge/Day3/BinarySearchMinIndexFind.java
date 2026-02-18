package dailychallenge.Day3;

public class BinarySearchMinIndexFind {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 4, 4, 5};

        int k = 4;

        System.out.print(binarysearch(nums, k));
    }
    public static int binarysearch(int[] nums, int k) {

        int left = 0;

        int rigth = nums.length-1;

        int result = -1;

        while(left <= rigth)
        {
            int mid = left + (rigth - left) / 2;

            if(nums[mid] == k)
            {
                result = mid;

                rigth = mid - 1;
            }

            else if(nums[mid] < k)
            {
                left = mid + 1;
            }

            else
            {
                rigth = mid - 1;
            }
        }
        return result;
    }
}