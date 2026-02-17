package dailychallenge.Day1;

public class FruitsIntoBaskets {
    public static void main(String[] args) {
        int[] arr = {1,1,2,3,2,2};

        System.out.print(totalFruit(arr));
    }
    public static int totalFruit(int[] fruits) {

        int start = 0;

        int maxLen = 0;

        int distinct = 0;

        int max = 0;

        for(int i : fruits)
        {
            if(i > max)
            {
                max = i;
            }
        }
        int[] freq = new int[max + 1];

        for(int end = 0; end <fruits.length; end++)
        {
            if(freq[fruits[end]] == 0)
            {
                distinct++;
            }
            freq[fruits[end]]++;

            while(distinct > 2)
            {
                freq[fruits[start]]--;

                if(freq[fruits[start]] == 0)
                {
                    distinct--;
                }
                start++;
            }
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }
}
