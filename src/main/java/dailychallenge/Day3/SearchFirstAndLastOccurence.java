package dailychallenge.Day3;

import java.util.Arrays;

public class SearchFirstAndLastOccurence {

    public static void main(String[] args) {

        int[] nums = {5,7,7,8,8,10};
        int target = 8;

        System.out.println(Arrays.toString(searchRange(nums, target)));
    }

    public static int[] searchRange(int[] nums, int target) {

        int[] res = {-1, -1};

        res[0] = findBoundary(nums, target, true);   // first occurrence
        res[1] = findBoundary(nums, target, false);  // last occurrence

        return res;
    }

    private static int findBoundary(int[] nums, int target, boolean findFirst) {

        int left = 0;
        int right = nums.length - 1;
        int result = -1;

        while(left <= right) {

            int mid = left + (right - left) / 2;

            if(nums[mid] < target) {
                left = mid + 1;
            }
            else if(nums[mid] > target) {
                right = mid - 1;
            }
            else {
                result = mid;

                if(findFirst) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return result;
    }
}
