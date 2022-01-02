package baekjoon.prob3190;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main3 {

    static int map[][];
    static HashMap<Integer, Character> dirInfo = new HashMap<>();
    static LinkedList<SnakeBody> snake = new LinkedList<>();
    static int N;
    static int[] dx = { 1, 0, -1, 0};	//우, 하, 좌, 상
    static int[] dy = { 0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        map = new int[N+1][N+1];
        int numOfApple = Integer.parseInt(bf.readLine());

        StringTokenizer st;
        int x,y;

        for (int i = 0; i < numOfApple; i++) {
            st = new StringTokenizer(bf.readLine());
            y = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());

            map[y][x] = 1; // 1 == 사과
        }

        int numOfDirInfo = Integer.parseInt(bf.readLine());

        int t;
        Character dir;

        for (int i = 0; i < numOfDirInfo; i++) {
            st = new StringTokenizer(bf.readLine());

            t = Integer.parseInt(st.nextToken());
            dir = st.nextToken().charAt(0);

            dirInfo.put(t, dir);
        }

        snake.add(new SnakeBody(0, 0));
        int time = playGame(new SnakeBody(2, 1), 0);
        System.out.println(time);
    }

    static public int playGame(SnakeBody snakeHead, int dir) {
        int time = 1;

        while(true) {

            if((snakeHead.x <= 0 || snakeHead.x > N) || (snakeHead.y <= 0 || snakeHead.y > N)) {
                return time;
            }

            if (map[snakeHead.y][snakeHead.x] == 2) //자기 자신몸에 닿은경우
                return time;

            if (map[snakeHead.y][snakeHead.x] == 0) { //꼬리제거
                SnakeBody sb = snake.poll();
                map[sb.y][sb.x] = 0; //x,y에 대한 통일이 안됨.
            }

            snake.add(new SnakeBody(snakeHead.x, snakeHead.y));
            map[snakeHead.y][snakeHead.x] = 2;

            if(dirInfo.containsKey(time)) {
                Character c = dirInfo.remove(time);
                if(c.equals('L')) {
                    dir = dir == 0 ? (dir + 3) % 4 : (dir - 1) % 4;
                }
                if(c.equals('D')) {
                    dir = (dir + 1) % 4;
                }
            }

            snakeHead.x = snakeHead.x + dx[dir];
            snakeHead.y = snakeHead.y + dy[dir];

            time++;
        }
    }

    static public class SnakeBody {
        int x;
        int y;

        public SnakeBody(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
