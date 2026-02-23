package dailychallenge.Day8;

public class DiagonalMatrixPattern {
    public static void main(String[] args) {
        int n = 4;

        int[][] arr = new int[n][n];

        int num = 1;

        for(int d = 0; d < n; d++)
        {
            int row = d;

            int col = 0;

            while(row >= 0)
            {
                arr[row][col] = num++;

                row--;

                col++;
            }
        }

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n - i; j++)
            {
                System.out.print(arr[j][i] + " ");
            }

            System.out.println();
        }
    }
}
