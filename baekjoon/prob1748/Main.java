package baekjoon.prob1748;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Long N = sc.nextLong();

        String strN = String.valueOf(N);

        long answer = 0;
        long tmp = 0;
        
        int i;

        if (strN.length() > 1) {
            //10의 자릿수의 경우 이전 자릿수 숫자들 길이 더해줌. 100의 자리수이면 9 + 90
            for (i = 1; i < strN.length(); i++) {
                answer += i * (9 * Math.pow(10, i - 1));
                tmp += (9 * Math.pow(10, i - 1));
            }

            Long diff = N - tmp;
            answer += strN.length() * diff;
        } else if (strN.length() == 1)
            answer = N;

        System.out.println(answer);
    }
}
