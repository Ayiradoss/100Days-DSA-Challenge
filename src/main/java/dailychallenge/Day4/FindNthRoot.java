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

        int left = 0;

        int rigth = m;

        while (left <= rigth)
        {
            int mid = left + (rigth - left) / 2;

            int power = solve(n, m, mid);

            if(power == 1)
            {
                return mid;
            }
            else if(power == 2)
            {
                rigth = mid - 1;
            }
            else
            {
                left = mid + 1;
            }
        }
        return -1;
    }

    private static int solve(int n, int m, int target)
    {
        int res = 1;

        for(int i = 1; i <= n; i++)
        {
            res *= target;

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