package dailychallenge.Day5;

public class VersionNumber {

    public static void main(String[] args) {
        String s1 = "6.32";
        String s2 = "6.32";

        System.out.print(check(s1, s2));
    }

    public static int check(String s1, String s2)
    {

        int[] num1 = parse(s1);
        int[] num2 = parse(s2);

        int len = Math.max(num1.length, num2.length);

        for (int i = 0; i < len; i++) {

            int n1 = i < num1.length ? num1[i] : 0;
            int n2 = i < num2.length ? num2[i] : 0;

            if (n1 < n2) return -1;
            if (n1 > n2) return 1;
        }

        return 0;
    }

    private static int[] parse(String s)
    {

        int count = 1;
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == '.')
            {
                count++;
            }
        }

        int[] arr = new int[count];

        int index = 0;
        int number = 0;
        int sign = 1;

        for (int i = 0; i < s.length(); i++)
        {

            char ch = s.charAt(i);

            if(ch == '-')
            {
                sign = -1;
            }
            else if (ch == '.')
            {
                arr[index++] = number * sign;
                number = 0;
                sign = 1;
            }
            else
            {
                number = number * 10 + (ch - '0');
            }
        }
        arr[index] = number * sign;

        return arr;
    }
}
