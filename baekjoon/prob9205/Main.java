package baekjoon.prob9205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int T;
    static int N; //편의점 갯수
    static int[] dest;
    static int[][] convArr;
    static boolean[] visit;
    static boolean answer = false;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int startPos[] = new int[2];

        T = Integer.parseInt(bf.readLine());

        for (int j = 0; j < T; j++) {
            N = Integer.parseInt(bf.readLine());
            convArr = new int[N + 2][2];
            visit = new boolean[N+2];
            dest = new int[2];

            StringTokenizer st = new StringTokenizer(bf.readLine());
            startPos[0] = Integer.parseInt(st.nextToken());
            startPos[1] = Integer.parseInt(st.nextToken());

            convArr[0] = startPos;

            for (int i = 1; i < N+1; i++) {
                st = new StringTokenizer(bf.readLine());
                int xy[] = new int[2];

                xy[0] = Integer.parseInt(st.nextToken());
                xy[1] = Integer.parseInt(st.nextToken());

                convArr[i] = xy;
            }

            st = new StringTokenizer(bf.readLine());
            dest[0] = Integer.parseInt(st.nextToken());
            dest[1] = Integer.parseInt(st.nextToken());
            convArr[N+1] = dest;
            visit[0] = true;
            dfs(startPos);

            if (answer)
                sb.append("happy").append("\n");
            else
                sb.append("sad").append("\n");

            answer = false;
        }

        System.out.print(sb.toString());
    }

    static public void dfs(int[] node) {

        int distance = 0;

        for (int i = 0; i < convArr.length; i++) {
            if (visit[i])
                continue;

            //방문하지 않은 노드이면 맨해튼 거리 계산 후 도달가능한지 판단
            distance = Math.abs(convArr[i][0] - node[0]) + Math.abs(convArr[i][1] - node[1]);
            if (distance > 1000) {
                continue;
            }
            else {
                //최종 목적지인 경우
                if (convArr[i][0] == dest[0] && convArr[i][1] == dest[1]) {
                    visit[i] = true;
                    answer = true;
                    return;
                } else {
                    visit[i] = true;
                    dfs(convArr[i]);
                }
            }
        }
    }
}

