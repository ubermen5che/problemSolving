package prob1436;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String tripleSix = "666";

        int N = sc.nextInt();
        int incN = 1;
        int i = 0;
        Integer result = 666;

        while(true){
            if (N == incN){
                System.out.println(result);
                break;
            }else {
                result += 1;
                if (String.valueOf(result).length() < 4)
                    continue;
                else {
                    if (String.valueOf(result).contains(tripleSix)){
                        incN++;
                    }
                }
            }
        }
    }
}
