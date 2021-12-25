package baekjoon.prob14503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] map;
    static boolean[][] mapVisit;
    static HashMap<Integer, int[]> dirForMap = new HashMap<>();
    static HashMap<Integer, Integer> dirForRobot = new HashMap<>();
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        mapVisit = new boolean[N][M];

        dirForMap.put(0, new int[] {-1, 0}); //북
        dirForMap.put(1, new int[] {0, 1}); //동
        dirForMap.put(2, new int[] {1, 0}); //남
        dirForMap.put(3, new int[] {0, -1}); //서

        dirForRobot.put(0, 3);
        dirForRobot.put(1, 0);
        dirForRobot.put(2, 1);
        dirForRobot.put(3, 2);

        st = new StringTokenizer(bf.readLine());
        int x,y,dir;

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        dir = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Robot robot = new Robot(x,y,dir);
        System.out.println(bfs(robot));

    }

    static public int bfs(Robot robot) {
        ArrayList<int []> queue = new ArrayList<>();
        int cnt = 0;
        int dirX = 0, dirY = 0;
        int cleanedCnt = 0;

        queue.add(new int[] {robot.x, robot.y});
        cnt++;
        int[] xy;

        while(!queue.isEmpty()) {

            //로봇의 현재위치
            xy = queue.remove(0);

            if (mapVisit[xy[0]][xy[1]])
                continue;

            mapVisit[xy[0]][xy[1]] = true;
             //현재 위치에서 현재 방향기준 왼쪽 방향부터 차례대로 탐색.

            //4방향으로 회전하며 탐색하되 왼쪽이 가장 우선시되도록 탐색함.
            for (int i = 0; i < 4; i ++) {
                robot.dir = dirForRobot.get(robot.dir);
                dirX = xy[0] + dirForMap.get(robot.dir)[0];
                dirY = xy[1] + dirForMap.get(robot.dir)[1];

                //우선 범위검사부터 진행
                if (dirX < 0 || dirX >= N || dirY < 0 || dirY >= M)
                    continue;

                //현재 위치에서 왼쪽 방향 체크
                if (map[dirX][dirY] != 1 && !mapVisit[dirX][dirY]) {
                    //robot 현재 위치기준 방향전환
                    queue.add(new int[] {dirX, dirY});
                    cnt++;
                    cleanedCnt = 0;
                    break;
                } else {
                    if (!queue.isEmpty())
                        queue.remove(0);
                    cleanedCnt++;
                }
            }

            //4방향 모두 벽이거나 이미 청소된 구역이라면
            if (cleanedCnt == 4) {
                //후진 가능한지 체크
                if (robot.dir == 0 || robot.dir == 2) { //북쪽이면 남쪽으로 후진
                    if (robot.dir == 0) { //북쪽이면 남쪽으로 후진해야함.
                        xy[0] = xy[0] + dirForMap.get(robot.dir+2)[0];
                        xy[1] = xy[1] + dirForMap.get(robot.dir+2)[1];
                    } else {
                        xy[0] = xy[0] + dirForMap.get(robot.dir-2)[0];
                        xy[1] = xy[1] + dirForMap.get(robot.dir-2)[1];
                    }
                } else if (robot.dir == 1 || robot.dir == 3) {
                    if (robot.dir == 1) {
                        xy[0] = xy[0] + dirForMap.get(robot.dir+2)[0];
                        xy[1] = xy[1] + dirForMap.get(robot.dir+2)[1];
                    } else {
                        xy[0] = xy[0] + dirForMap.get(robot.dir-2)[0];
                        xy[1] = xy[1] + dirForMap.get(robot.dir-2)[1];
                    }
                }

                //후진 가능 범위검사
                if (xy[0] < 0 || xy[0] >= N || xy[1] < 0 || xy[1] >= M)
                    continue;

                if (map[xy[0]][xy[1]] == 1)
                    return cnt;

                queue.add(new int[] {xy[0], xy[1]});
            }
        }
        return cnt;
    }

    public static class Robot {
        public int x;
        public int y;
        public int dir;

        public Robot (int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
}
