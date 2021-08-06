package baekjoon.prob1110;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Main main = new Main();

        Scanner keyboard = new Scanner(System.in);
        int n = keyboard.nextInt();
        int result = n;
        int cnt = 0;

        while(true)
        {
            result = main.genNewNum(result);
            if (n == result)
                break;
            cnt++;
        }

        System.out.println(cnt+1);
    }

    public int genNewNum(int num){

        String sNum = String.valueOf(num);
        String newNum = "";
        String tmp = "";
        //10보다 작은 수의 경우 가장 앞자리에 0을 붙여 두자리수로 만든다
        if (num < 10){
            tmp += "0";
            tmp += sNum;
            sNum = tmp;
        }
        //그렇지 않은 경우 수를 두자리로 분리한 후 각 자리수를 더한 결과값의 가장 오른쪽 값과
        //원래 입력을 받은 수의 가장 오른쪽 자리수를 새로 배치하여 새로운 숫자 만든다.
        //ex) 26 -> 2+6 = 8 -> 68

        String result = String.valueOf(Integer.parseInt(String.valueOf(sNum.charAt(0))) +
                Integer.parseInt(String.valueOf(sNum.charAt(1))));

        newNum = String.valueOf(sNum.charAt(1)) + result.charAt(result.length()-1);

        //System.out.println("newNum = " + newNum);
        return Integer.parseInt(newNum);
    }
}
