package baekjoon.prob7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static int N,M;
    static int[][] map;
    static int[] dx = {1, -1, 0, 0}; //열 방향의 순서는 동서남북
    static int[] dy = {0, 0, 1, -1}; //행
    static int day = 0;
    static LinkedList<int[]> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1)
                    queue.offer(new int[] {i,j});
            }
        }

        bfs();

    }

    static public void bfs() {
        int[] nodePos;
        int dirX, dirY;
        int row, col;

        while(!queue.isEmpty()) {
            nodePos = queue.poll();
            row = nodePos[0];
            col = nodePos[1];
            day = map[row][col];

            for (int i = 0; i < 4; i++) {
                dirX = col + dx[i];
                dirY = row + dy[i];

                if (dirX >= 0 && dirX < M && dirY >= 0 && dirY < N){
                    if (map[dirY][dirX] == 0) {
                        map[dirY][dirX] = map[row][col] + 1;
                        queue.add(new int[] {dirY, dirX});
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(day-1);
    }
}
