package prob9020;

//골드바흐의 추측

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    static boolean[] primeArr = new boolean[10001];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        ArrayList<Integer> inputs = new ArrayList<>();

        for (int i = 0; i < N; i++){
            inputs.add(Integer.parseInt(bf.readLine()));
        }

        primeSieve(10000);

        //입력값에 대해 2로 나눈 값이 소수라면 해이다.
        for (int t = 0; t < N; t++){
            int input = inputs.get(t);
            if (primeArr[input/2]) {
                System.out.println(input / 2 + " " + input / 2);
                continue;
            }

            for (int i = input / 2; i >= 2; i--){
                if (primeArr[i]){
                    int right = input - i;
                    if (primeArr[right]){
                        System.out.println(i + " " + right);
                        break;
                    }
                } else
                    continue;
            }
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
