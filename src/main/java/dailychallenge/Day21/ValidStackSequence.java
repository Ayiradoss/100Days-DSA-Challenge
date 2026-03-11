package dailychallenge.Day21;

import java.util.Stack;

public class ValidStackSequence {
    public static void main(String[] args) {
        int[] pushed = {1,2,3,4,5};

        int[] poped = {4,5,3,2,1};

        System.out.print(validateStackSequences(pushed,poped));
    }
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;

        for(int i = 0; i < pushed.length; i++)
        {
            stack.push(pushed[i]);

            while(!stack.isEmpty() && stack.peek() == popped[j])
            {
                stack.pop();
                j++;
            }
        }

        return stack.isEmpty();
    }
}
