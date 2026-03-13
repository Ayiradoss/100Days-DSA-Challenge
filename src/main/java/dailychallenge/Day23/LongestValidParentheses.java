package dailychallenge.Day23;

public class LongestValidParentheses {
    public static void main(String[] args) {
        String str = ")()())";

        System.out.print(longestValidParentheses(str));
    }
    public static int longestValidParentheses(String s) {
        int open = 0;
        int close = 0;
        int max = 0;

        for(int i = 0; i<s.length(); i++)
        {
            char ch = s.charAt(i);

            if(ch == '(')
            {
                open++;
            }
            else
            {
                close++;
            }
            if(open == close)
            {
                max = Math.max(max, close+open);
            }
            if(open < close)
            {
                open = close = 0;
            }
        }
        open = close = 0;

        for(int i = s.length()-1; i>= 0; i--)
        {
            char ch = s.charAt(i);

            if(ch == '(')
            {
                open++;
            }
            else
            {
                close++;
            }
            if(open == close)
            {
                max = Math.max(max, close+open);
            }
            if(open > close)
            {
                open = close = 0;
            }
        }
        return max;
    }
}
