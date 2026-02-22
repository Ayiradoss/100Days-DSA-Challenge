package dailychallenge.Day7;

import java.util.Arrays;

public class SetZeros {
    public static void main(String[] args) {
        int[][] arr = {{1,1,0}, {1,0,1}, {1,1,1}};

        solve(arr);
    }
    private static void solve(int[][] nums)
    {
        int row = nums.length;

        int col = nums[0].length;

        boolean firstRowZero = false;

        boolean firstColZero = false;

        for(int i = 0; i < col; i++)
        {
            if(nums[0][i] == 0)
            {
                firstRowZero = true;
            }
        }

        for(int j = 0; j < row; j++)
        {
            if(nums[j][0] == 0)
            {
                firstColZero = true;
            }
        }

        for(int i = 1; i < row; i++)
        {
            for(int j = 1; j < col; j++)
            {
                if(nums[i][j] == 0)
                {
                    nums[i][0] = 0;

                    nums[0][j] = 0;
                }
            }
        }

        for(int i = 1; i < row; i++)
        {
            for(int j = 1; j < col; j++)
            {
                if(nums[i][0] == 0 || nums[0][j] == 0)
                {
                    nums[i][j] = 0;
                }
            }
        }

        for(int i = 0; i < col; i++)
        {
            if(firstRowZero)
            {
                nums[0][i] = 0;
            }
        }

        for(int j = 0; j < row; j++)
        {
            if(firstColZero)
            {
                nums[j][0] = 0;
            }
        }

        System.out.print(Arrays.deepToString(nums));
    }
}
