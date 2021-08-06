package baekjoon.prob1271;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        String sMoney = keyboard.next();
        String sN = keyboard.next();

        BigInteger money = new BigInteger(sMoney);
        BigInteger N = new BigInteger(sN);

        BigInteger q = money.divide(N);
        BigInteger r = money.mod(N);

        System.out.println(q);
        System.out.println(r);
    }
}
