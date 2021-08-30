package prob18111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int B = 0;
    static int cost = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        int geo[][] = new int[N][M];

        int tmp = 0;


        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (tmp > 255)
                    tmp = 0;
                geo[i][j] = tmp++;
            }
        }


        /**
        for (int i = 0; i < N; i++){
            StringTokenizer st2 = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++){
                geo[i][j] = Integer.parseInt(st2.nextToken());
            }
        }
    **/

        if (isFlatten(geo)) {
            System.out.println(cost);
            System.out.println(geo[0][0]);
        }else {
            HashMap<String, Integer> minMax;
            Integer minMaxArr[] = new Integer[6];

            while(!isFlatten(geo)){
                minMax = getMinMax(geo);
                minMaxArr[0] = minMax.get("min");
                minMaxArr[1] = minMax.get("max");
                minMaxArr[2] = minMax.get("minPosX");
                minMaxArr[3] = minMax.get("minPosY");
                minMaxArr[4] = minMax.get("maxPosX");
                minMaxArr[5] = minMax.get("maxPosY");

                //가장 높은 블럭과 아닌 블럭들의 단계가 1차이 나는 경우
                if (Math.abs(minMaxArr[0] - minMaxArr[1]) == 1){
                    HashMap<String, Integer> costMap = new HashMap<>();

                    //case1 : 인벤토리에 보유한 블럭들을 이용해서 쌓는 경우
                    if (B >= calBlockUsingInv(geo, minMaxArr[0])){
                        costMap.put("inven", calBlockUsingInv(geo, minMaxArr[0]));
                    } else {
                        costMap.put("inven", 999999999);
                    }

                    //case2 : 그냥 파는 경우
                    costMap.put("dig", calDigBlock(geo, minMaxArr[1]) * 2);


                    if (costMap.get("inven") > costMap.get("dig")){
                        System.out.println((costMap.get("dig")+cost) + " " + minMaxArr[0]);
                        System.exit(0);
                    } else {
                        System.out.println(costMap.get("inven") + " " + (minMaxArr[1] + cost));
                        System.exit(0);
                    }
                }
                //계단이 1층이상인 경우
                //가장 높은 구역의 블럭을 가장 낮은 높이를 가진 구역으로 계속해서 이동시켜준다.
                //계속 반복한다면 n층 n-1층 두 층으로 나뉘어 위에 if문에 걸릴것
                else {
                    int average = (geo[minMaxArr[5]][minMaxArr[4]] + geo[minMaxArr[3]][minMaxArr[2]]) / 2;
                    if (average % 2 == 0) {
                        geo[minMaxArr[5]][minMaxArr[4]] -= geo[minMaxArr[5]][minMaxArr[4]] - average;
                    } else {
                        geo[minMaxArr[5]][minMaxArr[4]] -= (geo[minMaxArr[5]][minMaxArr[4]]-1) - average;
                    }
                    geo[minMaxArr[3]][minMaxArr[2]] += Math.abs(geo[minMaxArr[3]][minMaxArr[2]] - average);

                    cost += (3 * average);

                    //System.out.println(cost);
                }
            }
            System.out.println(cost + " " + geo[0][0]);
        }
    }

    public static boolean isFlatten(int[][] geo){
        int val = geo[0][0];
        Boolean flag = true;

        for(int i = 0; i < geo.length; i++){
            for(int j = 0; j < geo[0].length; j++){
                if(geo[i][j] != val) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    public static HashMap<String, Integer> getMinMax(int[][] geo){
        Integer max = geo[0][0];
        Integer min = geo[0][0];
        Integer maxPosX = 0;
        Integer maxPosY = 0;
        Integer minPosX = 0;
        Integer minPosY = 0;

        for(int i = 0; i < geo.length; i++){
            for(int j = 0; j < geo[0].length; j++){
                if(geo[i][j] > max) {
                    max = geo[i][j];
                    maxPosX = j;
                    maxPosY = i;
                }

                if(geo[i][j] < min) {
                    min = geo[i][j];
                    minPosX = j;
                    minPosY = i;
                }
            }
        }
        HashMap<String, Integer> minMax = new HashMap<>();

        minMax.put("max", max);
        minMax.put("min", min);
        minMax.put("maxPosX", maxPosX);
        minMax.put("maxPosY", maxPosY);
        minMax.put("minPosX", minPosX);
        minMax.put("minPosY", minPosY);

        return minMax;
    }

    public static int calBlockUsingInv(int geo[][], int min) {
        int cnt = 0;

        for (int i = 0; i < geo.length; i++) {
            for (int j = 0; j < geo[0].length; j++) {
                if (geo[i][j] == min) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static int calDigBlock(int geo[][], int max) {
        int cnt = 0;

        for (int i = 0; i < geo.length; i++) {
            for (int j = 0; j < geo[0].length; j++) {
                if (geo[i][j] == max) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
