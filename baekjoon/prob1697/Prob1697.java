package prob1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Prob1697 {

    static int[] time = new int[1000001];

    static int N;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfsSearch();

        /**
        for (int i = 0; i < 100; i++){
            System.out.println(i + " " + time[i]);
        }
         **/
    }

    public static void bfsSearch(){
        ArrayList<Integer> queue = new ArrayList<>();
        boolean[] visited = new boolean[100001];

        queue.add(N);
        visited[N] = true;

        while(!queue.isEmpty()){
            Integer pos = queue.remove(0);

            if (pos == K){
                System.out.println(time[K]);
                break;
            }

            //유효범위라면 queue에 넣음.
            if (pos >= 0 && pos < 100001) {
                //A가 B앞에 있을 때 A / 2
                //0일 경우 예외처리

                //A가 B뒤에 있을 때 A * 2
                if (N < K && pos != 0 && pos * 2 < 100001) {
                    if (!visited[pos * 2]) {
                        queue.add(pos * 2);
                        visited[pos * 2] = true;
                        time[pos * 2] = time[pos] + 1;
                    }
                }

                if (pos - 1 >= 0) {
                    if (!visited[pos - 1]) {
                        queue.add(pos - 1);
                        visited[pos - 1] = true;
                        time[pos - 1] = time[pos] + 1;
                    }
                }

                if (pos + 1 < 100001) {
                    if (!visited[pos + 1]) {
                        queue.add(pos + 1);
                        visited[pos + 1] = true;
                        time[pos + 1] = time[pos] + 1;
                    }
                }

                if (N > K && pos - 1 >= K){
                    System.out.println(N - K);
                    break;
                }
            }
        }
    }
}
