package dailychallenge.Day1;

public class SudokuSolver {
    private static final int SIZE = 9;

    private static final int EMPTY = 0;

    public static void main(String[] args){

        //int[][] board = new int[SIZE][SIZE];

        //Scanner sc = new Scanner(System.in);

        System.out.println("Enter 0 for Empty cells: ");
        int[][] board = {
                {5,3,0,0,7,0,0,0,0},
                {6,0,0,1,9,5,0,0,0},
                {0,9,8,0,0,0,0,6,0},
                {8,0,0,0,6,0,0,0,3},
                {4,0,0,8,0,3,0,0,1},
                {7,0,0,0,2,0,0,0,6},
                {0,6,0,0,0,0,2,8,0},
                {0,0,0,4,1,9,0,0,5},
                {0,0,0,0,8,0,0,7,9}
        };

//        for(int i = 0; i < SIZE; i++)
//        {
//            System.out.print("Row " + (i+1) + ": ");
//
//            String[] row = sc.nextLine().trim().split("\\s+");
//
//            for(int j = 0; j < SIZE; j++)
//            {
//                board[i][j] = Integer.parseInt(row[j]);
//
//            }
//        }

        System.out.println("\n Input Sudoku: ");

        printBoard(board);

        if(solveSudoku(board))
        {
            System.out.println("\n Output Sudoku: ");
            printBoard(board);
        }
        else {
            System.out.println("\nNo solution exists for this Sudoku puzzle.");
        }

        //sc.close();
    }
    private static void printBoard(int[][] board)
    {
        for(int i = 0; i < SIZE; i++)
        {
            if(i % 3 == 0 && i != 0)
            {
                System.out.println("-----------------------");
            }
            for(int j = 0; j < SIZE; j++)
            {
                if(j % 3 == 0 && j != 0)
                {
                    System.out.print(" | ");
                }
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    private static boolean solveSudoku(int[][] board)
    {
        for(int row = 0; row < SIZE; row++)
        {
            for(int col = 0; col < SIZE; col++)
            {
                if(board[row][col] == EMPTY)
                {
                    for(int num = 1; num <= SIZE; num++)
                    {
                        if(isValid(board, row, col, num))
                        {
                            board[row][col] = num;

                            if(solveSudoku(board))
                            {
                                return true;
                            }
                            else
                            {
                                board[row][col] = EMPTY;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(int[][] board, int row, int col, int num)
    {
        for(int j = 0; j < SIZE; j++)
        {
            if(board[row][j] == num)
            {
                return false;
            }
        }

        for(int i = 0; i < SIZE; i++)
        {
            if(board[i][col] == num)
            {
                return false;
            }
        }

        int boxRow = row - row % 3;

        int boxCol = col - col % 3;

        for(int i = boxRow; i < boxRow + 3; i++)
        {
            for(int j = boxCol; j < boxCol + 3; j++)
            {
                if(board[i][j] == num)
                {
                    return false;
                }
            }
        }
        return true;
    }
}
