package prob2292;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        if (N == 1)
            System.out.println(1);
        else {
            int multiple = 6;
            int step = 1;
            int ceil = 0;
            int preCeil = 1;
            while(true){
                ceil = preCeil + (step * multiple);
                if (N <= ceil){
                    System.out.println(step+1);
                    break;
                }
                preCeil = ceil;
                step++;
            }
        }
    }
}
