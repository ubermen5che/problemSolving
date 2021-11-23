package baekjoon.prob2941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String croString = bf.readLine();

        int answer = 0;
        Character ch;

        for (int i = 0; i < croString.length(); i++) {
            ch = croString.charAt(i);
            //System.out.println("i = " + " " + i + " " + "ch = " + ch + " " + "answer = " + answer);
            if (ch == 'c') {
                if (i + 1 < croString.length()) {
                    Character tmp = croString.charAt(i + 1);
                    if (tmp == '=' || tmp == '-') {
                        i++;
                        answer++;
                        continue;
                    }
                }
            } else if (ch == 'd') {
                //dz= 처리
                if (i + 2 < croString.length()) {
                    Character tmp = croString.charAt(i + 1);
                    Character tmp2 = croString.charAt(i + 2);

                    if (tmp == 'z' && tmp2 == '=') {
                        i += 2;
                        answer++;
                        continue;
                    } else if (tmp == '-') {
                        i++;
                        answer++;
                        continue;
                    }
                } else if (i + 1 < croString.length()) {
                    Character tmp = croString.charAt(i+1);

                    if (tmp == '-') {
                        i++;
                        answer++;
                        continue;
                    }
                }
            } else if (ch == 'l') {
                if (i + 1 < croString.length()) {
                    Character tmp = croString.charAt(i + 1);
                    if (tmp == 'j') {
                        i++;
                        answer++;
                        continue;
                    }
                }
            } else if (ch == 'n') {
                if (i + 1 < croString.length()) {
                    Character tmp = croString.charAt(i + 1);
                    if (tmp == 'j') {
                        i++;
                        answer++;
                        continue;
                    }
                }
            } else if (ch == 's') {
                if (i + 1 < croString.length()) {
                    Character tmp = croString.charAt(i + 1);
                    if (tmp == '=') {
                        i++;
                        answer++;
                        continue;
                    }
                }
            } else if (ch == 'z') {
                if (i + 1 < croString.length()) {
                    Character tmp = croString.charAt(i + 1);
                    if (tmp == '=') {
                        i++;
                        answer++;
                        continue;
                    }
                }
            }
            answer++;
        }
        System.out.println(answer);
    }
}
