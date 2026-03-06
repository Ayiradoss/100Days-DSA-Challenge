package dailychallenge.Day17;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperature {
    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};

        System.out.print(Arrays.toString(dailyTemperatures(temperatures)));
    }
    public static int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;

        int[] res = new int[n];

        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < n; i++)
        {
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()])
            {
                int prev = st.pop();

                res[prev] = i - prev;
            }
            st.push(i);
        }
        return res;
    }
}