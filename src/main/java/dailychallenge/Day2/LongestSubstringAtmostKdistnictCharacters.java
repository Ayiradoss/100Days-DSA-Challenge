package dailychallenge.Day2;

public class LongestSubstringAtmostKdistnictCharacters {
    public static void main(String[] args) {
        String s = "ababc";

        int k = 2;

        System.out.print(check(s, k));
    }
    private static int check(String s, int k)
    {
        if(k == 0)
        {
            return 0;
        }

        int start = 0;

        int maxLen = 0;

        int[] freq = new int[256];

        int distinct = 0;

        for(int i =0; i<s.length(); i++)
        {
            freq[s.charAt(i)]++;

            if(freq[s.charAt(i)] == 1)
            {
                distinct++;
            }
            while(distinct > k)
            {
                freq[s.charAt(start)]--;

                if(freq[s.charAt(start)] == 0)
                {
                    distinct--;
                }
                start++;
            }
            maxLen = Math.max(maxLen, i - start +1);
        }
        return maxLen;
    }
}