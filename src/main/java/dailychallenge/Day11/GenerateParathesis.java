package dailychallenge.Day11;

import java.util.ArrayList;
import java.util.List;

public class GenerateParathesis {
    public static void main(String[] args) {
        int n = 3;

        List<String> list = new ArrayList<>();

        bt(list, "", n, 0, 0);

        System.out.print(list);
    }
        public static void bt(List<String> list, String str, int n, int open, int close) {
            if (str.length() == n * 2) {
                list.add(str);

                return;
            }

            if (open < n) {
                bt(list, str + "(", n, open + 1, close);
            }
            if (close < open) {
                bt(list, str + ")", n, open, close + 1);
            }
        }
}
