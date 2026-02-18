package dailychallenge.Day3;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {3,1};

        int target = 3;

        System.out.print(search(nums, target));
    }
    public static int search(int[] nums, int target) {
        int left = 0;

        int rigth = nums.length-1;

        while(left <= rigth)
        {
            int mid = left + (rigth - left) / 2;

            if(nums[mid] == target)
            {
                return mid;
            }

            if(nums[left] <= nums[mid])
            {
                if(nums[left] <= target && target < nums[mid])
                {
                    rigth = mid - 1;
                }
                else
                {
                    left = mid + 1;
                }
            }
            else
            {
                if(nums[mid] < target && target <= nums[rigth])
                {
                    left = mid + 1;
                }
                else
                {
                    rigth = mid - 1;
                }
            }
        }
        return -1;
    }
}
