package dailychallenge.Day1;

public class FirstNegWindNoColl {
    public static void main(String[] args) {
        int[] arr = {-8, 2, 3, -6, 10};

        int k = 2;

        firstNegInt(arr, k);
    }

    public static void firstNegInt(int arr[], int k) {

        if (k <= 0 || arr.length < k) {
            System.out.print(0);
            return;
        }

        int n = arr.length;

        int firstNegative = 0;

        int start = 0;

        for(int end = 0; end < n; end++)
        {

            int windowSize = end - start + 1;

            if(windowSize < k)
            {
                continue;
            }

            if(windowSize == k)
            {
                while(firstNegative < n && firstNegative < start || arr[firstNegative] >= 0)
                {
                    firstNegative++;
                }
                if(firstNegative <= end)
                {
                    System.out.print(arr[firstNegative] + " ");
                }
                else
                {
                    System.out.print(0+" ");
                }
                start++;
            }
        }
    }
}