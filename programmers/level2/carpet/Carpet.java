package programmers.level2.carpet;
import java.util.*;

/**
 * 문제 이름 : 카펫
 * 유형 : 완전탐색
 * 문제 url : https://programmers.co.kr/learn/courses/30/lessons/42842
 *
 * 해결 방법
 * 처음 접근할 때 노란색 블럭이 카펫의 크기를 결정하는 핵심이라고 생각했다. 그래서 어떻게 하면 주어진 노란색 블럭의 갯수로 부터 노란색 전체 블럭의
 * 크기를 결정할 수 있을까 고민해보았다. 고민 결과 노란색 블록의 갯수의 약수들을 구해서 여러 경우의 가로, 세로 크기를 결정해볼 수 있었다.
 * ex) 12 -> (1,2,3,4,6,12) 1*12, 2*6, 3*4  이렇게 약수들끼리 곱했을 때 전체 블록의 갯수가 나오는 (가로,세로) 짝의 여러 경우를 구할 수 있었다.
 * 구하고 난 뒤 갈색 블록들과의 관계를 발견할 수 있었고 갈색 블록의 갯수 = (노란블록 가로 + 2) * 2 + (노란블록 세로 * 2) 라는 식을 얻을 수 있었다.
 * 위의 식을 만족하게될 때 (노란블록 가로 + 2) -> 카펫의 가로크기 (노란블록 세로 + 2) -> 카펫의 세로크기를 구할 수 있었다.
 *
 * 첫 시도때 테스트케이스 1,2,3에 대해서는 통과하지 못했는데 9 -> (1,3,9) 와 같이 홀수일 때의 경우를 처리해주지 않아서 처리해주었더니 통과되었다.
 *
**/

public class Carpet {

    class Solution {
        public int[] solution(int brown, int yellow) {
            int[] answer = {};
            int width = 0;

            ArrayList<Integer> divisorList = findDivisor(yellow);

            int hori, vert;
            int divListLen = divisorList.size();

            if (divListLen == 1){
                answer = new int[] {3,3};
                return answer;
            }

            if (divListLen % 2 == 0){
                for (int i = 0; i < divListLen / 2; i++){
                    hori = divisorList.get(divListLen - 1 - i);
                    vert = divisorList.get(i);

                    width = (hori + 2) * 2 + (vert * 2);

                    if (width == brown){
                        answer = new int[] {hori+2, vert+2};
                        return answer;
                    }
                }
            } else {
                for (int i = 0; i < (divListLen / 2) + 1; i++){
                    hori = divisorList.get(divListLen - 1 - i);
                    vert = divisorList.get(i);

                    width = (hori + 2) * 2 + (vert * 2);

                    if (width == brown){
                        answer = new int[] {hori+2, vert+2};
                        return answer;
                    }
                }
            }


            return answer;
        }

        public ArrayList<Integer> findDivisor(int a){

            ArrayList<Integer> divList = new ArrayList<>();

            for (int i = 1; i <= a; i++){
                if (a % i == 0)
                    divList.add(i);
            }

            return divList;
        }
    }
}
