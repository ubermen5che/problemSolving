package baekjoon.prob16926;

import java.util.*;
import java.io.*;

public class Main {
    static int dy[] = {0, 1, 0, -1};        // 우, 하, 좌, 상
    static int dx[] = {1, 0, -1, 0};
    static int N, M, R;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int group = Math.min(N, M) / 2;

        for (int i = 0; i < R; i++) {
            for (int j = 1; j <= group; j++) {
                int x = j;
                int y = j;

                int temp = arr[y][x];
                int idx = 0;
                while(idx < 4) {
                    int nY = y + dy[idx];
                    int nX = x + dx[idx];

                    if (nY >= j && nY <= N - j + 1 && nX >= j && nX <= M - j + 1) {
                        arr[y][x] = arr[nY][nX];
                        y = nY;
                        x = nX;
                    } else {
                        // 범위를 벗어나면 방향 전환
                        idx++;
                    }
                }
                // 다돌았으면 임시변수에 저장한 값을 arr에 넣어줌.
                arr[j + 1][x] = temp;
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}

