package baekjoon.prob1032;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        ArrayList<String> sList = new ArrayList<>();

        int n = keyboard.nextInt();

        //입력된 문자열(파일명)을 저장.
        for (int i = 0; i < n; i++) {
            String sInput = keyboard.next();
            sList.add(sInput);
        }

        int elementSize = sList.get(0).length();

        //?를 가지는 결과 문자열 미리 생성.
        String newString = "";
        //파일명이 담긴 ArrayList순회하며 각 문자열을 이루는 문자 각각에 대해 서로 동일한지 검사.

        int idx = 0;

        for (int i = 0; i < elementSize; i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                char tmp = sList.get(0).charAt(i);
                if (sList.get(j).charAt(i) != tmp) {
                    flag = false;
                    newString = newString + '?';
                    break;
                }
            }
            if(flag == true)
                newString += sList.get(0).charAt(i);
        }

        System.out.println(newString);
    }
}
