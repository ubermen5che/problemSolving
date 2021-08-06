package baekjoon.prob1037;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        ArrayList<Integer> divisorList = new ArrayList<>();

        int numOfDivisor = keyboard.nextInt();
        keyboard.nextLine();
        String Divisor = keyboard.nextLine();

        StringTokenizer stringTokenizer = new StringTokenizer(Divisor, " ");

        for (int i = 0; i < numOfDivisor; i++){
            divisorList.add(Integer.parseInt(stringTokenizer.nextToken()));
        }

        Collections.sort(divisorList);
        System.out.println(divisorList.get(0) * divisorList.get(divisorList.size()-1));
    }
}
