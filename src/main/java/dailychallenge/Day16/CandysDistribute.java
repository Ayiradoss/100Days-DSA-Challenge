package dailychallenge.Day16;

import java.util.Arrays;

public class CandysDistribute {
    public static void main(String[] args) {
        int[] candyType = {1,1,2,2,3,3};

        System.out.print(distributeCandies(candyType));
    }
    public static int distributeCandies(int[] candyType) {
        Arrays.sort(candyType);

        int unique = 1;

        for(int i = 1; i < candyType.length; i++)
        {
            if(candyType[i] != candyType[i-1])
            {
                unique++;
            }
        }
        return Math.min(unique, candyType.length / 2);
    }
}
