package programmers.level2;
import java.util.*;

/**
 * 문제 이름 : 기능개발
 * 레벨 : 2
 * 문제 유형 : queue
 * 문제 설명 : input으로 progresses[], speeds[]가 주어진다. progresses[]에는 100미만의 자연수가 100개 이하로 주어지고
 * speeds[]에는 각 progresses element(작업 진행도)의 작업속도정보가 주어진다 ex) progresses : [93, 30, 55]	speeds : [1, 30, 5]
 * 각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고, 이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포된다.
 * 먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와 각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때 각 배포마다 몇 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성하자.
 *
 * 참고 사항 : 배포는 하루에 한 번만 할 수 있으며, 하루의 끝에 이루어진다고 가정합니다. 예를 들어 진도율이 95%인 작업의 개발 속도가 하루에 4%라면 배포는 2일 뒤에 이루어집니다.
 *
 * 해결 방법 : queue에 progresses정보를 넣고 queue에서 제거할때마다 제거한 작업이 앞으로 얼마나 걸리는지 계산한 후 이후에 작업들이 이전 작업을 완료시에 함께
 * 완료되는 작업인지 확인 후 함께 완료되는 작업이라면 count해준다.
 *
 * 어려웠던 점 : 기능 구현에 있어서 필요한 변수 정의하기, 즉 logic설계가 아직 더디다는 생각.
 *
 *
 *
 *
 *
 */
public class FunctionDevelop {

    class Solution {
        public int[] solution(int[] progresses, int[] speeds) {
            int[] answer = {};
            Integer tempProg;

            ArrayList<Integer> queue = new ArrayList<>();
            ArrayList<Integer> result = new ArrayList<>();

            for (int i = 0; i < progresses.length; i++){
                queue.add(progresses[i]);
            }

            int i = 0;
            int cnt = 0;
            int day;

            while(!queue.isEmpty()){
                tempProg = queue.remove(0);
                cnt++;

                day = calcDay(tempProg, speeds[i++]);

                int tmp;

                while(!queue.isEmpty()){
                    tmp = queue.get(0);
                    //이전 작업 완료 시간동안 다음 task가 완료되었을 경우
                    if (tmp + (day * speeds[i]) >= 100){
                        cnt++;
                        i++;
                        queue.remove(0);
                    } else
                        break;
                }

                System.out.println("cnt : " + cnt);
                result.add(cnt);
                cnt = 0;
            }

            answer = new int[result.size()];

            for (int j = 0; j < result.size(); j++)
                answer[j] = result.get(j);

            return answer;
        }

        public int calcDay(int percent, int speeds){
            int i = 1;
            int day = 0;
            int progress = percent;

            while(progress < 100){
                progress += speeds;
                day++;
            }

            System.out.println("day : " + day);

            return day;
        }
    }
}
