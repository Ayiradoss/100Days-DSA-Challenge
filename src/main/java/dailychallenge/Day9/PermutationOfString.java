package dailychallenge.Day9;

public class PermutationOfString {
    public static void main(String[] args) {
        String str = "DAS";

        bt(str.toCharArray(), 0);
    }
    private static void bt(char[] arr, int index)
    {
        if(index == arr.length)
        {
            System.out.println(new String(arr));

            return;
        }

        for(int i = index; i < arr.length; i++)
        {
            swap(arr, index, i);

            bt(arr, index+1);

            swap(arr, index, i);
        }
    }
    private static void swap(char[] arr, int i, int j)
    {
        char temp = arr[i];

        arr[i] = arr[j];

        arr[j] = temp;
    }
}
