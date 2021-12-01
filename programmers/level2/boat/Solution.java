package programmers.level2.boat;

import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int lt=0;
        int rt=people.length-1;
        while(lt<=rt) {
            int sum = people[lt]+people[rt];
            if(lt!=rt-- && sum<=limit) lt++;
            answer++;
        }
        return answer;
    }
}
