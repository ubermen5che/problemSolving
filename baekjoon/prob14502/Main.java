package baekjoon.prob14502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N,M;
    static int initSafeArea = 0;
    static int safetyArea = 0;
    static ArrayList<int[]> safeAreaXY;
    static ArrayList<int[]> safeAreaIdxList;
    static boolean[] visit;
    static int[] safeAreaIdxArr;
    static int[] idxComb = new int[3];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int max;

    public static void main(String[] args) throws IOException {

        ArrayList<int[]> infectedAreaList;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int map[][];
        StringTokenizer tokenizer = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());

        map = new int[N][M];
        safeAreaXY = new ArrayList<>();
        safeAreaIdxList = new ArrayList<>();
        infectedAreaList = new ArrayList<>();

        //map 생성 및 추후 answer 도출을 연산에 필요한 초기 안전지역 갯수 cnt
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    initSafeArea++;
                    safeAreaXY.add(new int[] {i, j});
                } else if (map[i][j] == 2) {
                    infectedAreaList.add(new int[] {i,j}); //bfs시 시작점
                }
            }
        }

        safeAreaIdxArr = new int[safeAreaXY.size()];
        for (int i = 0; i < safeAreaXY.size(); i++) {
            safeAreaIdxArr[i] = i;
        }

        visit = new boolean[safeAreaIdxArr.length];

        //벽 3개 놓을 수 있는 경우의 수 구함
        combination(0, 3, 0);
        boolean[][] mapVisit = new boolean[N][M];

        max = 0;

        for (int i = 0; i < safeAreaIdxList.size(); i++) {

            int[][] clonedMap = new int[map.length][map[0].length];

            for (int j = 0; j < map.length; j++) {
                System.arraycopy(map[j], 0, clonedMap[j], 0, map[0].length);
            }

            int[][] wallIdx = new int[3][2];
            int[] tmp = safeAreaIdxList.get(i); //tmp에는 safeAreaIdx에 존재하는 좌표의 조합의 경우를 담음

            for (int k = 0; k < 3; k++) {
                wallIdx[k] = safeAreaXY.get(tmp[k]);
            }



            for (int k = 0; k < 3; k++) {
                clonedMap[wallIdx[k][0]][wallIdx[k][1]] = 1;
            }


            /**
            clonedMap[0][4] = 1;
            clonedMap[1][3] = 1;
            clonedMap[3][3] = 1;
            **/
            bfs(infectedAreaList, mapVisit, clonedMap);

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (clonedMap[j][k] == 0)
                        safetyArea++;
                }
            } ;

            if (max < safetyArea)
                max = safetyArea;

            safetyArea = 0;
            mapVisit = new boolean[N][M];
        }
        System.out.println(max);
    }

    static public void combination(int start, int r, int depth) {
        if (r == 0) {
            int[] tmp = new int[3];

            for (int i = 0; i < 3; i++) {
                tmp[i] = idxComb[i];
            }

            safeAreaIdxList.add(tmp);
            return;
        }

        for (int i = start; i < safeAreaIdxArr.length; i++) {
            if (visit[i])
                continue;

            visit[i] = true;
            idxComb[depth] = i;
            combination(i, r-1, depth+1);
            visit[i] = false;
        }
    }

    static public void bfs(ArrayList<int[]> start, boolean[][] mapVisit, int[][] map) {
        ArrayList<int[]> queue = new ArrayList<>();
        int xy[];
        int dirX, dirY;

        //queue에 감염 시작점 넣어줌.
        for (int i = 0; i < start.size(); i++) {
            queue.add(start.get(i));
        }

        while(!queue.isEmpty()) {
            xy = queue.remove(0);

            if (mapVisit[xy[0]][xy[1]])
                continue;

            mapVisit[xy[0]][xy[1]] = true;
            //상,하,좌,우 격자 검사
            for (int i = 0; i < 4; i++) {
                dirX = xy[0] + dx[i];
                dirY = xy[1] + dy[i];
                //유효범위 체크
                if (dirX < 0 || dirX >= N ||
                        dirY < 0 || dirY >= M)
                    continue;

                //이미 감염된 지역이거나 벽은 감염대상이 아님.
                if (map[dirX][dirY] == 1 || map[dirX][dirY] == 2) {
                    continue;
                } else {
                    if (!mapVisit[dirX][dirY])
                        map[dirX][dirY] = 2;
                        queue.add(new int[] {dirX, dirY});
                }
            }
        }

    }
}
