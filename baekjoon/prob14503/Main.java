package baekjoon.prob14503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int r,c;
    static int dir;
    static int[] dx = {0, 1 , 0, -1}; //동서남북
    static int[] dy = {-1, 0, 1, 0};
    static int[][] map;
    static int answer = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        dir = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(findAnswer(r,c));
    }

    static public int findAnswer(int y, int x) {

        int count = 0;
        int nextX = 0;
        int nextY = 0;

        while(true) {

            map[y][x] = 2;
            count++;

            for (int i = 0; i < 4; i++) {
                dir = dir == 0 ? dx.length - 1 : dir - 1; //왼쪽으로 회전
                nextX = x + dx[dir];
                nextY = y + dy[dir];

                if (x < 0 || x >= M || y < 0 || y >= N)
                    return -1;

                if (map[nextY][nextX] == 0) {
                    x = nextX;
                    y = nextY;
                    break;
                }

                if (i == 3) { // i가 3이 될때 까지 break가 안되었음. 즉 4방향 다돌아봤는데 모든 방향이 벽또는 이미 청소한 영역
                    int backDir = dir <= 1 ? dx.length - Math.abs(dir - 2) : dir - 2;

                    int backX = x + dx[backDir];
                    int backY = y + dy[backDir];

                    if (map[backY][backX] == 1)
                        return count;

                    x = backX;
                    y = backY;
                    i = -1;
                }
            }
        }
    }
}
