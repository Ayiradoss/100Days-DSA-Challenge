package dailychallenge.Day2;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String s = "ABAB";

        int k = 2;

        System.out.print(characterReplacement(s, k));
    }
    public static int characterReplacement(String s, int k) {

        int[] freq = new int[26];

        int start = 0;

        int maxFreq = 0;

        int maxLen = 0;

        for(int end = 0; end < s.length(); end++)
        {
            freq[s.charAt(end) - 'A']++;

            maxFreq = Math.max(maxFreq, freq[s.charAt(end) - 'A']);

            int windowSize = end - start + 1;

            while(windowSize - maxFreq > k)
            {
                freq[s.charAt(start) - 'A']--;

                start++;

                windowSize = end - start + 1;
            }

            maxLen = Math.max(maxLen, windowSize);
        }
        return maxLen;
    }
}
