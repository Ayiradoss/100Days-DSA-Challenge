package dailychallenge.Day7;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};

        spiral(matrix);
    }
    private static void spiral(int[][] matrix)
    {
        int row = matrix.length;

        int col = matrix[0].length;

        int left = 0;

        int rigth = col - 1;

        int top = 0;

        int bottom = row - 1;

        while(left <= rigth && top <= bottom)
        {
            for(int i = left; i <= rigth; i++)
            {
                System.out.print(matrix[top][i]+" ");
            }
            top++;

            for(int i = top; i <= bottom; i++)
            {
                System.out.print(matrix[i][rigth]+" ");
            }
            rigth--;

            if(top <= bottom)
            {
                for(int i = rigth; i >= left; i--)
                {
                    System.out.print(matrix[bottom][i]+" ");
                }
                bottom--;
            }

            if(left <= rigth)
            {
                for(int i = bottom; i >= top; i--)
                {
                    System.out.print(matrix[i][left]+" ");
                }
                left++;
            }
        }
    }
}
