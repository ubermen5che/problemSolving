package baekjoon.prob2407;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *  시간 제한 : 2초
 *  문제 접근 : N, M의 최대값이 100이므로 파스칼의 삼각형을 이용한 조합 계산을 이용한다. nCr = n-1Cr-1 + n-1Cr
 *  시간 복잡도 : O(N^2)
 */
public class P_2407_조합 {

    static int N, M;
    static BigInteger[][] comb;
    static BigInteger zero = new BigInteger("0");
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        comb = new BigInteger[N + 1][M + 1];

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= M; j++)
                comb[i][j] = new BigInteger("0");
        }
        combination(N, M);
        System.out.println(comb[N][M]);
    }

    static BigInteger combination(int N, int M) {
        if (M == 0 || N == M)
            return comb[N][M] = new BigInteger("1");
        else {
            if (comb[N][M].compareTo(zero) == 0)
                return comb[N][M] = combination(N - 1, M - 1).add(combination(N - 1, M));
            else
                return comb[N][M];
        }
    }
}
