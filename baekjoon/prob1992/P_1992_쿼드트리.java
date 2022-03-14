package baekjoon.prob1992;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_1992_쿼드트리 {
    static int N;
    static int[][] map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            for (int j = 1; j <= N; j++) {
                map[i][j] = line.charAt(j - 1) - '0';
            }
        }
        if (compact(1, 1, N)) {
            sb.append(map[1][1]);
        } else {
            sb.append("(");
            findAnswer(1, 1, N);
            sb.append(")");
        }

        System.out.println(sb);
    }

    static void findAnswer(int x, int y, int size) {
        // 좌상단 체크
        if (compact(x, y, size / 2)) {
            sb.append(map[y][x]);
        } else {
            sb.append("(");
            findAnswer(x, y, size / 2);
            sb.append(")");
        }
        // 우상단 체크
        if (compact(x + size / 2, y, size / 2)) {
            sb.append(map[y][x + size / 2]);
        } else {
            sb.append("(");
            findAnswer(x + size / 2, y, size / 2);
            sb.append(")");
        }
        // 좌하단 체크
        if (compact(x, y + size / 2, size / 2)) {
            sb.append(map[y + size / 2][x]);
        } else {
            sb.append("(");
            findAnswer(x, y + size / 2, size / 2);
            sb.append(")");
        }
        // 우하단 체크
        if (compact(x + size / 2, y + size / 2, size / 2)) {
            sb.append(map[y + size / 2][x + size / 2]);
        } else {
            sb.append("(");
            findAnswer(x + size / 2, y + size / 2, size / 2);
            sb.append(")");
        }
    }
    static boolean compact(int startX, int startY, int size) {
        int digit = map[startY][startX];

        for (int i = startY; i < startY + size; i++) {
            for (int j = startX; j < startX + size; j++) {
                if (map[i][j] != digit)
                    return false;
            }
        }
        return true;
    }
}
