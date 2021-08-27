package prob2609;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//최대공약수(GCD) 최소공배수(LCM) 구하는 알고리즘
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.println(getGCD(a,b));
        System.out.println(getLCM(a,b));
    }

    public static int getGCD(int a, int b){
        //각 수에 대한 약수 구해서 가장 큰 공통 약수를 구함
        ArrayList<Integer> divisorListA = new ArrayList<>();
        ArrayList<Integer> divisorListB = new ArrayList<>();

        divisorListA.add(1);
        divisorListB.add(1);

        int divider = 2;

        while(true){
            if (divider <= a) {
                if (a % divider == 0)
                    divisorListA.add(divider);
            }

            if (divider <= b) {
                if (b % divider == 0)
                    divisorListB.add(divider);
            }

            if (divider > a && divider > b)
                break;

            divider++;
        }

        int minSize = divisorListA.size() > divisorListB.size() ? divisorListB.size() : divisorListA.size();

        int i = 0;
        int j = 0;
        int aListSize = divisorListA.size();
        int bListSize = divisorListB.size();

        while(true){
            if (divisorListA.get((aListSize-1)-i).equals(divisorListB.get((bListSize-1)-j)))
                return divisorListA.get(aListSize-1-i);
            else if (divisorListA.get(aListSize-1-i) > divisorListB.get(bListSize-1-j))
                i++;
            else
                j++;
        }
    }

    public static int getLCM(int a, int b){
        int aMultiple = 1;
        int bMultiple = 1;

        while(true){
            if (a * aMultiple == b * bMultiple)
                return a * aMultiple;
            else if (a * aMultiple >  b * bMultiple)
                bMultiple++;
            else
                aMultiple++;
        }
    }
}
