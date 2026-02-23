package dailychallenge.Day8;

public class DiagonalPattern {
    public static void main(String[] args) {

        int n = 5;

        patter(n);
    }
    private static void patter(int n)
    {
        int num = 1;

        int[][] arr = new int[n][n];

        for(int col = 0; col < n; col++)
        {
            for(int row = col; row < n; row++)
            {
                arr[row][col] = num++;
            }
        }

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j <= i; j++)
            {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}