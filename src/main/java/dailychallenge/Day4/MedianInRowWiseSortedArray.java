package dailychallenge.Day4;

public class MedianInRowWiseSortedArray {
    public static void main(String[] args) {
        int[][] mat = {{1, 3, 5},{2, 6, 9},{3, 6, 9}};

        System.out.print(median(mat));
    }
    private static int median(int[][] mat)
    {
        int r = mat.length;

        int c = mat[0].length;

        int low = Integer.MAX_VALUE;

        int high = Integer.MIN_VALUE;

        int required = (r * c + 1) / 2;

        for(int i = 0; i < r; i++)
        {
            low = Math.min(low, mat[i][0]);

            high = Math.max(high, mat[i][c-1]);
        }

        while(low < high)
        {
            int mid = low + (high - low) / 2;

            int count = 0;

            for(int i = 0; i<r; i++)
            {
                count += lessOrEqual(mat[i], c, mid);
            }
            if(count < required)
            {
                low = mid + 1;
            }
            else
            {
                high = mid;
            }
        }
        return low;
    }
    private static int lessOrEqual(int[] row, int c, int target)
    {
        int left = 0;

        int rigth = c - 1;

        while (left <= rigth)
        {
            int mid = left + (rigth - left);

            if(row[mid] <= target)
            {
                left = mid + 1;
            }
            else
            {
                rigth = mid - 1;
            }
        }
        return left;
    }
}
