package dailychallenge.Day11;

import java.util.ArrayList;
import java.util.List;

public class PalindromPartition {

    public static void main(String[] args) {

        String s = "ayiradass";

        List<List<String>> result = partition(s);

        System.out.println("Palindrome Partitions:");

        for(List<String> list : result) {
            System.out.println(list);
        }
    }

    public static List<List<String>> partition(String s) {

        List<List<String>> list = new ArrayList<>();

        bt(list, new ArrayList<>(), s, 0);

        return list;
    }

    public static void bt(List<List<String>> list, List<String> tempList, String s, int start) {

        if(start == s.length()) {
            list.add(new ArrayList<>(tempList));
            return;
        }

        for(int end = start; end < s.length(); end++)
        {

            if(palin(start, s, end))
            {

                tempList.add(s.substring(start, end + 1));

                bt(list, tempList, s, end + 1);

                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static boolean palin(int start, String s, int end) {

        int left = start;
        int right = end;

        while (left < right)
        {

            if (s.charAt(left) != s.charAt(right))
            {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}