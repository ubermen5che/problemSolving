package baekjoon.samsung.prob13458;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int numOfRoom;
        int numOfSv[];
        int numOfPeople[];
        long answer = 0;

        numOfRoom = Integer.parseInt(bf.readLine());

        numOfPeople = new int[numOfRoom];
        StringTokenizer st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < numOfRoom; i++) {
            numOfPeople[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(bf.readLine());
        numOfSv = new int[2];

        for (int i = 0; i < 2; i++){
            numOfSv[i] = Integer.parseInt(st.nextToken());
        }

        //총감독 감독가능인원을 각 시험장 인원에서 빼줌
        for (int i = 0; i < numOfRoom; i++){
            numOfPeople[i] -= numOfSv[0];
            answer++;
        }

        //각 시험장 인원 / 부감독 감독가능인원
        for (int i = 0; i < numOfRoom; i++) {
            if (numOfPeople[i] > 0 && numOfPeople[i] <= numOfSv[1]) {
                numOfPeople[i] -= numOfSv[1];
                answer++;
                continue;
            }

            if (numOfPeople[i] > numOfSv[1]) {
                if (numOfPeople[i] % numOfSv[1] == 0) {
                    answer += numOfPeople[i] / numOfSv[1];
                } else {
                    answer += numOfPeople[i] / numOfSv[1] + 1;
                }
            }
        }

        System.out.println(answer);
    }
}
