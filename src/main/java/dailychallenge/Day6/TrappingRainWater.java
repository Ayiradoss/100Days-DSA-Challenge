package dailychallenge.Day6;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};

        System.out.print(trap(height));
    }
    public static int trap(int[] height) {
        int left = 0;

        int rigth = height.length-1;

        int leftmax = 0;

        int rigthmax = 0;

        int water = 0;

        while(left < rigth)
        {
            if(height[left] < height[rigth])
            {
                if(height[left] >= leftmax)
                {
                    leftmax = height[left];
                }
                else
                {
                    water += leftmax - height[left];
                }
                left++;
            }
            else
            {
                if(height[rigth] >= rigthmax)
                {
                    rigthmax = height[rigth];
                }
                else
                {
                    water += rigthmax - height[rigth];
                }
                rigth--;
            }
        }
        return water;
    }
}
