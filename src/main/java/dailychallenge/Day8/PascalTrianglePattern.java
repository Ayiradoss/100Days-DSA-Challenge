package dailychallenge.Day8;

public class PascalTrianglePattern {
    public static void main(String[] args) {
        int n = 5;

        pattern(n);
    }
    private static void pattern(int n)
    {
        int space = n;

        int num = 1;

        for(int i = 0; i < n; i++)
        {
            for(int spa = 0; spa < n - i - 1; spa++)
            {
                System.out.print(" ");
            }
            num = 1;

            for(int j = 0; j <= i; j++)
            {
                System.out.print(num + " ");

                num = num * (i - j) / (j + 1);
            }
            System.out.println();
        }
    }
}
