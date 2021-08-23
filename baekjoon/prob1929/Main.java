package prob1929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Integer N = Integer.parseInt(st.nextToken());
        Integer M = Integer.parseInt(st.nextToken());

        ArrayList<Boolean> primeList;

        // n <= 1 일 때 종료
        if(N < 1 && M > 1000000) return;

        // n+1만큼 할당
        primeList = new ArrayList<Boolean>(M+1);
        // 0번째와 1번째를 소수 아님으로 처리
        primeList.add(false);
        primeList.add(false);
        // 2~ n 까지 소수로 설정
        for(int i=2; i<=M; i++ )
            primeList.add(i, true);

        // 2 부터  ~ i*i <= n
        // 각각의 배수들을 지워간다.
        for(int i=2; (i*i)<=M; i++){
            if(primeList.get(i)){
                for(int j = i*i; j<=M; j+=i) primeList.set(j, false);
                //i*i 미만은 이미 처리되었으므로 j의 시작값은 i*i로 최적화할 수 있다.
            }
        }
        ArrayList<Integer> result = new ArrayList<>();

        for(int i=0; i<=M; i++){
            if(primeList.get(i) == true && i >= N){
                result.add(i);
            }
        }

        for(Integer pn : result){
            System.out.println(pn);
        }
    }
}
