package baekjoon.prob2468;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static AreaInfo map[][];
    static boolean visit[][];
    static int maxLevel = 0;
    static int[] dx = new int[] {1, -1, 0, 0};
    static int[] dy = new int[] {0, 0, 1 ,-1};

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        map = new AreaInfo[N][N];
        visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = new AreaInfo(Integer.parseInt(st.nextToken()), 0);
                if (map[i][j].level > maxLevel)
                    maxLevel = map[i][j].level;
            }
        }

        ArrayList<Integer> areaSize = new ArrayList<>();

        for (int k = 0; k <= maxLevel; k++) {
            int cnt = 1;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visit[i][j] && map[i][j].level > k) {
                        map[i][j].area = cnt;
                        bfs(new int[]{i, j}, k, cnt++);
                    }
                }
            }
            areaSize.add(cnt-1);
            initArr();
            visit = new boolean[N][N];
        }

        Collections.sort(areaSize);
        System.out.println(areaSize.get(areaSize.size()-1));
    }

    static public int bfs(int[] pos, int level, int cnt) {
        LinkedList<int[]> queue = new LinkedList<>();
        int xy[];
        int x, y;
        int dirX, dirY;
        int areaCnt = 0;

        queue.add(pos);

        while(!queue.isEmpty()) {
            xy = queue.poll();

            x = xy[1];
            y = xy[0];

            if (visit[y][x])
                continue;

            visit[y][x] = true;

            for (int i = 0; i < 4; i++) {
                dirX = x + dx[i];
                dirY = y + dy[i];

                if (dirX >= 0 && dirX < N && dirY >= 0 && dirY < N) {
                    //area가 0이라면 아직 영역 표시가 되지 않은경우 이므로 표시해줌
                    if (map[dirY][dirX].level > level && map[dirY][dirX].area == 0) {
                        map[dirY][dirX].area = map[y][x].area;
                        queue.add(new int[] {dirY, dirX});
                    }
                }
            }
        }
        return cnt;
    }

    static public void initArr() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j].area = 0;
            }
        }
    }

    static class AreaInfo {
        int level;
        int area;

        public AreaInfo(int level, int area){
            this.level = level;
            this.area = area;
        }
    }
}
