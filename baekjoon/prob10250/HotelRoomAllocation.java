package prob10250;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class HotelRoomAllocation {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        ArrayList<String> resultList = new ArrayList<>();

        for (int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            resultList.add(result(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        for (String r : resultList){
            System.out.println(r);
        }
    }

    public static String result(int H, int W, int N){
        // 1 예외처리
        if (H == 1){
            String result = "";

            result += H;

            if (String.valueOf(N).length() == 1) {
                result += "0";
            }

            result += N;
            return result ;
        }

        // 전체 인원을 height로 나누면 Room번호가 나올것.
        int height = (N % H);
        int room = (N / H) + 1;

        //나머지가 0인경우와 아닌경우 구분
        //case1 : 나머지가 없으면 각 층 꽉 찼으므로 방번호는 W일것. (예와 : 2 4 4의 경우 모두 차지 않았어서 W를 room으로 하면안됨.)
        if (height == 0){
            if (W * H > N){
                String tmp = "";
                int r = N / H;
                tmp += H;
                if (String.valueOf(r).length() == 1){
                    tmp += "0";
                }
                tmp += r;
                return tmp;
            }

            room = W;
            String tmp = "";
            if (String.valueOf(room).length() == 1){
                tmp += H;
                tmp += "0";
                tmp += String.valueOf(W);
                return tmp;
            }
            return H + String.valueOf(W);
        }
        else {  //case2 : 나머지가 0이 아니면 해당층은 N % H 값이 층이 될것. ex) 13 % 6 = 1이므로 1층임.
            String tmp = "";
            tmp += height;
            if (String.valueOf(room).length() == 1){
                tmp += "0";
            }
            tmp += room;

            return tmp;
        }
    }
}
