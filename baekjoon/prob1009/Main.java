package prob1009;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        int T = keyboard.nextInt();
        int[] result = new int[T];

        for (int i = 0; i < T; i++) {
            int a = keyboard.nextInt();
            int exp = keyboard.nextInt();
            int c = 1;

            for (int b = 0; b < exp; b++){
                c *= a;
                c %= 10;
            }

            if (c == 0)
                result[i] = 10;
            else
                result[i] = c;
        }

        for (int i = 0; i < T; i++){
            System.out.println(result[i]);
        }

        keyboard.close();
    }
}
