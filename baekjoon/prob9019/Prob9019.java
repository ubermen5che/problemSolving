package prob9019;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Prob9019 {

    static String[] command = new String[10000]; // 정답 담는곳
    static boolean[] visited = new boolean[10000]; // BFS 탐색의 방문 여부 체크
    static int start;
    static int target;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        ArrayList<String> resultList = new ArrayList<>();

        for (int i = 0; i <n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            start = Integer.parseInt(st.nextToken());
            target = Integer.parseInt(st.nextToken());

            Arrays.fill(command, "");
            Arrays.fill(visited, false);
            bfsSearch(start, target);
            resultList.add(command[target]);
        }

        for (String s : resultList){
            System.out.println(s);
        }
    }

    public static void bfsSearch(int s, int t) {
        Queue<Integer> q = new LinkedList<>();

        q.add(s);

        while (!q.isEmpty() && !visited[target]){
            int now = q.poll();
            int D = (2*now)%10000;
            int S = (now == 0) ? 9999 : now-1;
            int L = (now % 1000) * 10 + now/1000;
            int R = (now % 10) * 1000 + now/10;

            if(!visited[D] && D != 0){
                q.add(D);
                visited[D] = true;
                command[D] = command[now] + "D";
            }

            if(!visited[S]){
                q.add(S);
                visited[S] = true;
                command[S] = command[now] + "S";
            }
            if(!visited[L]){
                q.add(L);
                visited[L] = true;
                command[L] = command[now] + "L";
            }
            if(!visited[R]){
                q.add(R);
                visited[R] = true;
                command[R] = command[now] + "R";
            }
        }
    }
}
