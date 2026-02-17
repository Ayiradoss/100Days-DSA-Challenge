package dailychallenge.Day2;

public class MinimumWindowSubString {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";

        String t = "ABC";

        System.out.print(minWindow(s, t));
    }
    public static String minWindow(String s, String t) {
        if(s.length() < t.length())
        {
            return "";
        }
        int[] freq = new int[128];

        for(int i = 0; i<t.length(); i++)
        {
            freq[t.charAt(i)]++;
        }

        int count = t.length();

        int start = 0;

        int left = 0;

        int minLen = Integer.MAX_VALUE;

        for(int end = 0; end < s.length(); end++)
        {
            char ch = s.charAt(end);

            freq[ch]--;

            if(freq[ch] >= 0)
            {
                count--;
            }

            while(count == 0)
            {
                int windowSize = end - left + 1;

                if(windowSize < minLen)
                {
                    minLen = windowSize;

                    start = left;
                }

                char ch1 = s.charAt(left);

                freq[ch1]++;

                if(freq[ch1] > 0)
                {
                    count++;
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
