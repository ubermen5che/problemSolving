package baekjoon.prob1835;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class prob1835 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int result[] = new int[N];
        ArrayList<Integer> index = new ArrayList<>();

        //init
        for (int i = 0; i < N; i++){
            result[i] = -1;
            index.add(i);
        }

        int cnt = 1;

        for (int i = 0; i < N; i++){
            for (int j = 0; j <= i; j++) {
                if (!index.isEmpty() && index.size() != 1) {
                    Integer tmp = index.remove(0);
                    index.add(tmp);
                }

                if (index.size() == 1){
                    result[index.get(0)] = cnt;
                }
            }
            result[index.get(0)] = cnt++;
            index.remove(0);
        }


        for (int i = 0; i < N-1; i++)
            System.out.print(result[i] + " ");

        System.out.println(result[N-1]);
    }
}
