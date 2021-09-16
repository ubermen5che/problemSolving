package baekjoon.prob1926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Picture {

    static int N = 0;
    static int M = 0;
    static int[][] map;
    static ArrayList<Integer> pictureSize = new ArrayList<>();
    static boolean[][] visited;
    static int picCnt = 0;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0 ,0};


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++){
            StringTokenizer line = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(line.nextToken());
            }
        }
        Math.abs()

        pictureSize.add(0);

        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (!visited[i][j] && map[i][j] == 1){
                    picCnt++;
                    bfs(i,j);
                }
            }
        }
        Collections.sort(pictureSize);
        System.out.println(picCnt);
        System.out.println(pictureSize.get(pictureSize.size()-1));
    }

    public static void bfs(int x, int y){
        int cnt = 0;
        LinkedList<int []> queue = new LinkedList<>();

        int queX;
        int queY;

        queue.add(new int[] {x,y});

        if (map[x][y] == 1){
            cnt++;
            visited[x][y] = true;
        }

        while(!queue.isEmpty()){
            queX = queue.peek()[0];
            queY = queue.peek()[1];

            queue.poll();

            int posX, posY;

            for (int i = 0; i < 4; i++){
                posX = queX + dx[i];
                posY = queY + dy[i];

                if ( posX >= 0 && posX < N && posY >= 0 && posY < M){
                    if (!visited[posX][posY] && map[posX][posY] == 1){
                        queue.add(new int[] {posX, posY});
                        visited[posX][posY] = true;
                        cnt++;
                    }
                }
            }
        }
        pictureSize.add(cnt);
    }
}
