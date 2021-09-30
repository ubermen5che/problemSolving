package programmers.level1.Gymsuit;
import java.util.*;

public class GymSuit {

    class Solution {
        public int solution(int n, int[] lost, int[] reserve) {
            int answer = 0;
            boolean[] visited = new boolean[31];
            //arr -> list
            ArrayList<Integer> lostList = new ArrayList<Integer>();
            ArrayList<Integer> reserveList = new ArrayList<Integer>();

            for (int i = 0; i < lost.length; i++){
                lostList.add(lost[i]);
            }

            for (int i = 0; i < reserve.length; i++){
                reserveList.add(reserve[i]);
            }

            Collections.sort(lostList);
            Collections.sort(reserveList);

            ArrayList<Integer> tmpList = new ArrayList<>();

            //lost에 reserve가 포함되어있는 경우 reserve제거로직
            for (int i = 0; i < lost.length; i++){
                Integer tmp = lostList.get(i);

                if (reserveList.contains(tmp)){
                    reserveList.remove(tmp);
                    tmpList.add(tmp);
                }
            }

            for (int i = 0; i < tmpList.size(); i++){
                lostList.remove(tmpList.get(i));
            }

            answer = n - lostList.size();

            //reserveList 토대로 answer계산
            for (int i = 0; i < reserveList.size(); i++){
                Integer tmp = reserveList.get(i);

                //본인 체격에서 -1 +1인 학생이 있을경우
                if (lostList.contains(tmp-1) && !visited[tmp] && !visited[tmp-1]){
                    visited[tmp] = true;
                    visited[tmp-1] = true;
                    answer++;
                }
                else if (lostList.contains(tmp+1) && !visited[tmp] && !visited[tmp+1]){
                    visited[tmp] = true;
                    visited[tmp+1] = true;
                    answer++;
                }
            }

            return answer;
        }
    }
}
