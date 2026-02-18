package dailychallenge.Day3;

public class Sqrt {
    public static void main(String[] args)
    {
        int x = 4;

        System.out.print(mySqrt(x));
    }
    public static int mySqrt(int x)
    {

        if(x < 2)
        {
            return x;
        }

        int left = 0;

        int rigth = x / 2;

        int res = 0;

        while(left <= rigth)
        {
            int mid = left + (rigth - left) / 2;

            long sqrt =  (long) mid * mid;

            if(sqrt == x)
            {
                return mid;
            }
            else if(sqrt < x)
            {
                left = mid + 1;

                res = mid;
            }
            else
            {
                rigth = mid - 1;
            }
        }
        return res;
    }
}