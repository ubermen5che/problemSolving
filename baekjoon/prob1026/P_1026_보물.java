package baekjoon.prob1026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P_1026_보물 {

    static int N;
    static int[] A, B, ATmp;
    static Info[] BTmp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        A = new int[N];
        ATmp = new int[N];
        B = new int[N];
        BTmp = new Info[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            ATmp[i] = A[i];
        }

        Arrays.sort(ATmp);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            B[i] = value;
            BTmp[i] = new Info(i, value);
        }

        Arrays.sort(BTmp);

        for (int i = 0; i < N; i++) {
            Info info = BTmp[i];
            A[info.idx] = ATmp[i];
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer += A[i] * B[i];
        }

        System.out.println(answer);
    }

    static class Info implements Comparable<Info>{
        int idx;
        int value;

        Info (int idx, int value) {
            this.idx = idx;
            this.value = value;
        }

        @Override
        public int compareTo(Info o) {
            return o.value - this.value;
        }
    }
}
