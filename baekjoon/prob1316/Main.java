package baekjoon.prob1316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> inputs = new ArrayList<>();
        ArrayList<Character> charList = new ArrayList<>();
        int answer = 0;

        int N = Integer.parseInt(bf.readLine());
        Character tmp;
        for (int i = 0; i < N; i++){
            //문자열을 입력받자 어디다가? ArrayList
            inputs.add(bf.readLine());
        }

        String input = "";
        Character ch;

        boolean flag = true;

        for (int i = 0; i < inputs.size(); i++){
            input = inputs.get(i);
            tmp = input.charAt(0);
            charList.add(tmp);

            for (int j = 1; j < input.length(); j++){
                ch = input.charAt(j);

                //이전문자와 현재문자가 같다. 즉 연속으로 나타난 문자이면 continue
                if (tmp == ch)
                    continue;
                //이전에 검사한 문자와 현재 문자가 다를경우
                //만약 charList에 없는 문자이면 tmp 갱신해주고 charList에 add
                //존재하는 문자이면 break;
                if (tmp != ch) {
                    if (!charList.contains(ch)) {
                        tmp = ch;
                        charList.add(ch);
                    } else {
                        flag = false;
                        //System.out.println("ch = " + ch);
                        //System.out.println("i = " + i + " " + "j = " + j);
                        break;
                    }
                }
            }
            charList.clear();

            if (flag == true)
                answer++;
            flag = true;
        }

        System.out.println(answer);
    }
}
