package prob1436;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int initN = 1;
        int result = 666;


        while(N != initN){
            if (initN % 19 != 7){
                result += 1000;
                initN += 1;
                if (initN % 19 == 7 && N == initN)
                    result -= 6;
            } else{
                result -= 6;
                if (initN == N)
                    break;
                for (int i = 0; i < 9; i++) {
                    result += 1;
                    initN += 1;
                    if (initN == N){
                        System.out.println(result);
                        System.exit(0);
                    }
                }
                result -= 3;
            }
        }
        System.out.println(result);
    }
}
