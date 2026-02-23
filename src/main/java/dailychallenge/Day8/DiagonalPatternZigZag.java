package dailychallenge.Day8;

public class DiagonalPatternZigZag {
    public static void main(String[] args) {
        int n = 5;

        int num = 1;

        for(int i = 1; i<=n; i++)
        {
            int start = num;

            int end = num + i - 1;

            if(i % 2 == 0)
            {
                for(int j = end; j >= start; j--)
                {
                    System.out.print(j + " ");
                }
            }
            else
            {
                for(int j = start; j <= end; j++)
                {
                    System.out.print(j + " ");
                }
            }

            num = end + 1;

            System.out.println();
        }
    }
}
