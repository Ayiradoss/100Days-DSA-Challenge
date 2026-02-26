package dailychallenge.Day11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {

    public static void main(String[] args) {

        int n = 4;

        List<List<String>> result = solveNQueens(n);

        System.out.println("Solutions:");

        for(List<String> board : result){
            System.out.println();
            for(String row : board){
                System.out.println(row);
            }
        }
    }

    public static List<List<String>> solveNQueens(int n) {

        List<List<String>> list = new ArrayList<>();

        char[][] grid = new char[n][n];

        for(char[] row : grid){
            Arrays.fill(row,'.');
        }

        bt(list,0,grid,n);

        return list;
    }

    public static void bt(List<List<String>> list,int row,char[][] grid,int n){

        if(row == n){

            List<String> res = new ArrayList<>();

            for(char[] ch : grid){
                res.add(new String(ch));
            }

            list.add(res);
            return;
        }

        for(int col = 0; col < n; col++){

            if(isSafe(row,col,grid,n)){

                grid[row][col] = 'Q';

                bt(list,row+1,grid,n);

                grid[row][col] = '.';
            }
        }
    }

    public static boolean isSafe(int row,int col,char[][] grid,int n){

        // check column
        for(int i=row-1;i>=0;i--){
            if(grid[i][col]=='Q'){
                return false;
            }
        }

        // left diagonal
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(grid[i][j]=='Q'){
                return false;
            }
        }

        // right diagonal
        for(int i=row-1,j=col+1;i>=0 && j<n;i--,j++){
            if(grid[i][j]=='Q'){
                return false;
            }
        }

        return true;
    }
}