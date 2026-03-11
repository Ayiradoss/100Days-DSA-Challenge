package dailychallenge.Day21;

import java.util.Stack;

public class SimplifyPath {
    public static void main(String[] args) {
        String path = "/home//foo/";

        System.out.print(simplifyPath(path));
    }
    public static String simplifyPath(String path)
    {
        Stack<String> stack = new Stack<>();

        String[] parts = path.split("/");

        for(String part : parts)
        {
            if(part.equals("") || part.equals("."))
            {
                continue;
            }

            else if(part.equals(".."))
            {
                if(!stack.isEmpty())
                {
                    stack.pop();
                }
            }

            else
            {
                stack.push(part);
            }
        }

        StringBuilder result = new StringBuilder();

        for(String dir : stack)
        {
            result.append("/").append(dir);
        }
        return result.length() == 0 ? "/" : result.toString();
    }
}