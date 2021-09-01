package prob9020.fail;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;

public class failGoldBach {

    public static void main(String[] args) throws IOException {
        try {
            OutputStream outputStream = new FileOutputStream("/Users/yong/github/PS/baekjoon/prob9020/fail.txt");
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

            //int N = Integer.parseInt(bf.readLine());
            ArrayList<Integer> input = new ArrayList<>();

            int cnt2 = 2;

            while (true) {
                if (2 * cnt2 <= 10000)
                    input.add(2 * cnt2);
                else
                    break;
                cnt2++;
            }

            Collections.sort(input);
            ArrayList<Integer> primeList = primeSieve(input.get(input.size() - 1));
            int tmpArr[] = new int[2];

            for (int t = 0; t < 10000; t++) {
                int tmp = input.get(t);
                int idx = getIdx(primeList, tmp);
                int minDiff = 999999;
                int cnt = -1;
                String strTmp = "";

                for (int i = 0; i < idx; i++) {
                    for (int j = i; j < idx; j++) {
                        if (tmp == primeList.get(i) + primeList.get(j)) {
                            if (cnt == -1) {
                                int diffTmp = Math.abs(primeList.get(i) - primeList.get(j));
                                minDiff = diffTmp;
                                strTmp = primeList.get(i) + " " + primeList.get(j);
                                cnt++;
                                continue;
                            } else {
                                int absDiff = Math.abs(primeList.get(i) - primeList.get(j));
                                if (absDiff == 0) {
                                    strTmp = primeList.get(i) + " " + primeList.get(j);
                                    break;
                                }
                                if (absDiff < minDiff) {
                                    minDiff = absDiff;
                                    strTmp = primeList.get(i) + " " + primeList.get(j);
                                }
                            }
                        }
                    }
                }
                String str = strTmp + "\n";
                byte[] by = str.getBytes(StandardCharsets.UTF_8);
                outputStream.write(by);
            }
        } catch (Exception e){
            e.getStackTrace();
        }
    }

    public static ArrayList<Integer> primeSieve(int max){
        boolean[] prime = new boolean[max+1];

        for(int i = 2; i < max+1; i++)
            prime[i] = true;

        for(int p = 2; p*p <= max; p++){
            if(prime[p] == true){
                for(int i = p*p; i <= max; i += p)
                    prime[i]= false;
            }
        }

        ArrayList<Integer> primeList = new ArrayList<>();

        for(int i = 0; i < prime.length; i++){
            if (prime[i] == true)
                primeList.add(i);
        }

        return primeList;
    }

    public static int getIdx(ArrayList<Integer> primeList, int n){
        int idx = 0;

        for (Integer integer : primeList){
            if (integer < n)
                idx++;
            else
                break;
        }

        return idx;
    }
}
