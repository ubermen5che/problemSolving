package baekjoon.prob18111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FinalMain {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int max = 0;
        int min = Integer.MAX_VALUE;

        int geo[][] = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                geo[i][j] = Integer.parseInt(st.nextToken());
                if (geo[i][j] > max)
                    max = geo[i][j];
                if (geo[i][j] < min)
                    min = geo[i][j];
            }
        }

        int time = Integer.MAX_VALUE;
        int height = 0;

        for (int i = min; i <= max; i++) {
            int removedBlocks = 0;
            int buildingBlocks = 0;

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    int tmp = i - geo[j][k];

                    if (tmp < 0) {  //현재 높이보다 높은 경우 캔다.
                        removedBlocks += tmp * -1;
                    } else
                        buildingBlocks += tmp;
                }
            }

            if (buildingBlocks <= removedBlocks + B) {
                int tmp = removedBlocks * 2 + buildingBlocks;
                if (time > tmp) {
                    time = tmp;
                    height = i;
                }

                if (tmp == time) {
                    if (height < i)
                        height = i;
                }
            }
        }
        System.out.println(time + " " + height);
    }
}
