package dailychallenge.Day17;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement1 {
    public static void main(String[] args) {
        int[] nums1 = {2,4};

        int[] nums2 = {1,2,3,4};

        System.out.print(Arrays.toString(nextGreaterElement(nums1, nums2)));
    }
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();

        Stack<Integer> st = new Stack<>();

        for(int i = nums2.length-1; i>=0; i--)
        {
            while(!st.isEmpty() && st.peek() <= nums2[i])
            {
                st.pop();
            }
            int num = st.isEmpty() ? -1  : st.peek();

            map.put(nums2[i], num);

            st.push(nums2[i]);
        }
        int[] res = new int[nums1.length];

        for(int i = 0; i<nums1.length; i++)
        {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
