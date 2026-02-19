package dailychallenge.Day4;

public class FindNthRoot {
    public static void main(String[] args) {
        int n = 3;

        int m = 27;

        System.out.print(nthRoot(n, m));
    }
    public static int nthRoot(int n, int m) {

        if(m == 0)
        {
            return 0;
        }

        int left = 1;

        int rigth = m;

        while(left <= rigth)
        {
            int mid = left + (rigth - left) / 2;

            int solve = power(mid, n, m);

            if(solve == 1)
            {
                return mid;
            }
            else if(solve == 0)
            {
                left = mid + 1;
            }
            else
            {
                rigth = mid - 1;
            }
        }
        return -1;
    }
    private static int power(int mid, int n, int m)
    {
        long res = 1;

        for(int i = 1; i <= n; i++)
        {
            res *= mid;

            if(res > m)
            {
                return 2;
            }
        }
        if(res == m)
        {
            return 1;
        }
        return 0;
    }
}
