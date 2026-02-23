package dailychallenge.Day8;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class MirrorPattern {
    public static void main(String[] args) {
        int n = 5;

        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= n - i + 1; j++)
            {
                System.out.print(j);
            }

            for(int s = 1; s <= (i-1) * 2; s++)
            {
                System.out.print(" ");
            }

            for(int j = n - i + 1; j >= 1; j--)
            {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
