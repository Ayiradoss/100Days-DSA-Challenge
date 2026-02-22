package dailychallenge.Day7;

public class Search2DArray {
    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};

        int target = 3;

        System.out.print(searchMatrix(matrix, target));
    }
    public static boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;

        int n = matrix[0].length;

        int row = 0;

        int col = n-1;

        while(row < m && col >= 0)
        {
            if(matrix[row][col] == target)
            {
                return true;
            }
            else if(matrix[row][col] > target)
            {
                col--;
            }
            else
            {
                row++;
            }
        }
        return false;
    }
}
