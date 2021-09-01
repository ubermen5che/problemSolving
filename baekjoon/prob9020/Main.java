package prob9020;

//골드바흐의 추측

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import java.util.Collections;

public class Main {

    static boolean[] primeArr = new boolean[10001];

    public static void main(String[] args) throws IOException {
        try {
            OutputStream outputStream = new FileOutputStream("/Users/yong/github/PS/baekjoon/prob9020/correct.txt");

            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

            //int N = Integer.parseInt(bf.readLine());
            ArrayList<Integer> inputs = new ArrayList<>();

            int cnt = 2;

            while (true) {
                if (2 * cnt <= 10000)
                    inputs.add(2 * cnt);
                else
                    break;
                cnt++;
            }

            primeSieve(10000);

            //입력값에 대해 2로 나눈 값이 소수라면 해이다.
            for (int t = 0; t < 10000; t++) {
                int input = inputs.get(t);
                if (primeArr[input / 2]) {
                    String str = input / 2 + " " + input / 2 + "\n";
                    byte[] by = str.getBytes(StandardCharsets.UTF_8);
                    outputStream.write(by);
                    continue;
                }

                for (int i = input / 2; i >= 2; i--) {
                    if (primeArr[i]) {
                        int right = input - i;
                        if (primeArr[right]) {
                            String str = i + " " + right + "\n";
                            byte[] by = str.getBytes(StandardCharsets.UTF_8);
                            outputStream.write(by);
                            break;
                        }
                    } else
                        continue;
                }
            }
        } catch (Exception e){
            e.getStackTrace();
        }
    }

    public static void primeSieve(int max){

        for(int i = 2; i < max+1; i++)
            primeArr[i] = true;

        for(int p = 2; p*p <= max; p++){
            if(primeArr[p] == true){
                for(int i = p*p; i <= max; i += p)
                    primeArr[i]= false;
            }
        }
    }
}
