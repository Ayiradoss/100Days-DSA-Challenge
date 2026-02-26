package dailychallenge.Day9;

public class MazeRun {
    static int N = 4;

    public static void main(String[] args) {

        int[][] maze = {{1,0,0,0}, {1,1,0,1}, {0,1,0,0}, {1,1,1,1}};

        boolean[][] visited = new boolean[N][N];

        solve(maze, 0, 0, "", visited);
    }

    private static void solve(int[][] maze, int i, int j, String s, boolean[][] visited)
    {
        if(i == N-1 && j == N-1)
        {
            System.out.print(s);

            return;
        }
        if(i < 0 || j < 0 || i >= N || j >= N || maze[i][j] == 0 || visited[i][j])
        {
            return;
        }
        visited[i][j] = true;

        solve(maze, i+1, j, s+"Down", visited);
        solve(maze, i, j+1, s+"Rigth", visited);
        solve(maze, i-1, j, s+"Up", visited);
        solve(maze, i, j-1, s+"Left", visited);

        visited[i][j] = false;
    }
}