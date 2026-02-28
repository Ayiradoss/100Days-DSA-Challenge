package dailychallenge.Day12;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        List<List<Integer>> list = new ArrayList<>();
        backTrack(list, n, k, 1, new ArrayList<>());
        System.out.print(list);
    }
    private static void backTrack(List<List<Integer>> list, int n, int k, int start, List<Integer> tempList) {
        if(k == 0) {
            list.add(new ArrayList<>(tempList));
            return;
        }
        for(int i = start; i <= n; i++) {
            tempList.add(i);
            backTrack(list, n, k - 1, i+1, tempList);
            tempList.remove(tempList.size() - 1);
        }
    }
}
