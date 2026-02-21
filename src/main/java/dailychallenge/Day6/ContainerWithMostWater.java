package dailychallenge.Day6;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] nums = {1,8,6,2,5,4,8,3,7};

        System.out.print(maxArea(nums));
    }
    public static int maxArea(int[] nums) {
        int left = 0;

        int rigth = nums.length-1;

        int maxArea = 0;

        while(left < rigth)
        {
            int width = rigth - left;

            int curhei = Math.min(nums[left], nums[rigth]);

            int area = curhei * width;

            maxArea = Math.max(maxArea, area);

            if(nums[left] < nums[rigth])
            {
                left++;
            }
            else
            {
                rigth--;
            }
        }
        return maxArea;
    }
}
