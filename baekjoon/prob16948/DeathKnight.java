package prob16948;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DeathKnight {

    static int N;
    static int[] arrivePos;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        int[][] board = new int[N][N];
        boolean[][] visited = new boolean[N][N];

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int[] pos = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        arrivePos = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

        bfsSearch(board, pos, visited);
        if (board[arrivePos[0]][arrivePos[1]] != 0)
            System.out.println(board[arrivePos[0]][arrivePos[1]]);
        else
            System.out.println(-1);
    }

    public static void bfsSearch(int[][] board, int[] pos, boolean[][] visited){
        ArrayList<int[]> queue = new ArrayList<>();

        int r;
        int c;

        queue.add(pos);

        while(!queue.isEmpty()) {
            int[] node = queue.remove(0);

            r = node[0];
            c = node[1];

            if (!visited[r][c]) {
                visited[r][c] = true;

                //(r-2, c-1) 범위 체크 후 유효범위이면 queue에 넣음.
                if ((r - 2 >= 0 && r - 2 < N) && (c - 1 >= 0 && c - 1 < N)) {

                    queue.add(new int[]{r - 2, c - 1});
                    if (!visited[r-2][c-1])
                        board[r - 2][c - 1] = board[r][c] + 1;
                }
                //(r-2, c+1)
                if ((r - 2 >= 0 && r - 2 < N) && (c + 1 >= 0 && c + 1 < N)) {

                    queue.add(new int[]{r - 2, c + 1});

                    if (!visited[r-2][c+1])
                        board[r - 2][c + 1] = board[r][c] + 1;
                }

                //(r, c-2)
                if ((r >= 0 && r < N) && (c - 2 >= 0 && c - 2 < N)) {

                    queue.add(new int[]{r, c - 2});
                    if (!visited[r][c-2])
                        board[r][c - 2] = board[r][c] + 1;
                }

                //(r, c+2)
                if ((r >= 0 && r < N) && (c + 2 >= 0 && c + 2 < N)) {

                    queue.add(new int[]{r, c + 2});
                    if (!visited[r][c+2])
                        board[r][c + 2] = board[r][c] + 1;
                }

                //(r+2, c-1)
                if ((r + 2 >= 0 && r + 2 < N) && (c - 1 >= 0 && c - 1 < N)) {
                    queue.add(new int[]{r + 2, c - 1});
                    if (!visited[r+2][c-1])
                        board[r + 2][c - 1] = board[r][c] + 1;
                }

                //(r+2, c+1)
                if ((r + 2 >= 0 && r + 2 < N) && (c + 1 >= 0 && c + 1 < N)) {
                    queue.add(new int[]{r + 2, c + 1});
                    if (!visited[r+2][c+1])
                        board[r + 2][c + 1] = board[r][c] + 1;
                }
            } else {

                if ((r - 2 >= 0 && r - 2 < N) && (c + 1 >= 0 && c + 1 < N)) {
                    if (visited[r - 2][c + 1] && (board[r - 2][c + 1] > board[r][c] + 1)) {
                        board[r - 2][c + 1] = board[r][c] + 1;
                    }
                }

                if ((r - 2 >= 0 && r - 2 < N) && (c - 1 >= 0 && c - 1 < N)) {
                    if (visited[r - 2][c - 1] && (board[r - 2][c - 1] > board[r][c] + 1)) {
                        board[r - 2][c - 1] = board[r][c] + 1;
                    }
                }

                if ((r >= 0 && r < N) && (c - 2 >= 0 && c - 2 < N)) {
                    if (visited[r][c - 2] && (board[r][c - 2] > board[r][c] + 1)) {
                        board[r][c - 2] = board[r][c] + 1;
                    }
                }

                if ((r >= 0 && r < N) && (c + 2 >= 0 && c + 2 < N)) {
                    if (visited[r][c + 2] && (board[r][c + 2] > board[r][c] + 1)) {
                        board[r][c + 2] = board[r][c] + 1;
                    }
                }

                if ((r + 2 >= 0 && r + 2 < N) && (c - 1 >= 0 && c - 1 < N)) {
                    if (visited[r + 2][c - 1] && (board[r + 2][c - 1] > board[r][c] + 1)) {
                        board[r + 2][c - 1] = board[r][c] + 1;
                    }
                }

                if ((r + 2 >= 0 && r + 2 < N) && (c + 1 >= 0 && c + 1 < N)) {
                    if (visited[r + 2][c + 1] && (board[r + 2][c + 1] > board[r][c] + 1)) {
                        board[r + 2][c + 1] = board[r][c] + 1;
                    }
                }
            }
        }
    }
}
