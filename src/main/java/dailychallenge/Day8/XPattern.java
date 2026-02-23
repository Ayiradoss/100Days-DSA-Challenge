package dailychallenge.Day8;

import java.util.Scanner;

public class XPattern {

    public static void main(String[] args) {

            String word = "break";

            int n = word.length();

            if(n % 2 == 0)
            {
                System.out.print("String length must be odd");
            }
            else
            {
                for(int i = 0; i < n; i++) {

                    for(int j = 0; j < n; j++) {

                        if(j == i)
                            System.out.print(word.charAt(i));

                        else if(j == n - i - 1)
                            System.out.print(word.charAt(n - i - 1));

                        else
                            System.out.print(" ");
                    }

                    System.out.println();
                }
            }
        }
}