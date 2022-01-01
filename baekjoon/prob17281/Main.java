package baekjoon.prob17281;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static int[][] inningResult;
    static boolean[] permVisit = new boolean[10];
    static int[] permArr =  new int[10];
    static int score = Integer.MIN_VALUE;
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        inningResult = new int[N][9];

        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < 9; j++) {
                inningResult[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long startTime = System.currentTimeMillis();
        permutation(1);
        long endTime = System.currentTimeMillis();
        //System.out.println((endTime - startTime));
        System.out.println(score);
    }

    static public int playGame(int N) {
        int outCnt = 0;
        int score = 0;
        int order = 0;
        int result = 0;
        boolean ru[];


        for (int i = 0; i < N; i++) {   //N이닝 만큼 경기진행
            outCnt = 0;
            ru = new boolean[3];

            while(outCnt < 3) { //아웃 카운트 3이면 이닝종료 아니라면 계속 진행
                order++;
                if (order >= 10) {
                    order = order % 10;
                    if (order == 0)
                        order = 1;
                }
                //System.out.println(playerOrder.size());
                result = inningResult[i][permArr[order]-1];

                if (result == 4) {
                    for (int j = 0; j < ru.length; j++) {
                        if (ru[j]) {
                            score += 1;
                            ru[j] = false;
                        }
                    }
                    score += 1;
                } else if ( result == 1 ) { //안타인 경우
                    for (int j = 2; j >= 0; j--) {
                        if (ru[j]) {
                            if (j == 2) {
                                score += 1;
                            } else {
                                ru[j+1] = true;
                            }
                            ru[j] = false;
                        }
                    }
                    ru[0] = true;
                } else if ( result == 2 ) { // 2루타의 경우
                    for (int j = 2; j >= 0; j--) {
                        if (ru[j]) {
                            if (j == 2 || j == 1) { //3루, 2루에 있는 타자 득점
                                score += 1;
                            } else { //1루에 있는 타자 3루로 진출
                                ru[j+2] = true;
                            }
                            ru[j] = false;
                        }
                    }
                    ru[1] = true; //2루타 친 선수 2루로 진출
                }  else if ( result == 3 ) { //3루타의 경우
                    for (int j = 2; j >= 0; j--) {
                        if (ru[j]) {
                            if (j == 2 || j == 1 || j == 0) { //1,2,3루 모두 득점
                                score += 1;
                            }
                            ru[j] = false;
                        }
                    }
                    ru[2] = true; //3루타친 선수 3루로 진출
                }  else if ( result == 0 ) {
                    outCnt++;
                    if (outCnt == 3)
                        break;
                }
            }
        }
        return score;
    }
    static public void permutation(int depth) {
        if (depth == 10) {
            score = Math.max(score, playGame(N));
            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (permVisit[i])
                continue;
            if (i == 1 && depth != 4)
                continue;

            permVisit[i] = true;
            permArr[depth] = i;
            permutation(depth+1);
            permVisit[i] = false;
        }
    }
}
