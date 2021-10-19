package programmers.level1.failureRate;

import java.util.*;

/**
 * 문제 분류 : 구현
 * 핵심 : 두가지 정렬기준을 이용해서 값을 정렬할 수 있는가?
 *
 * 각 stage별 실패율 계산해서 실패확률과 stageNum 두가지 요소를 정렬기준으로 삼고 정렬 후 가장 실패율이 높은 stageNum을
 * 내림차순으로 return해주는 문제.
 */
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer;
        ArrayList<FailAndStage> list = new ArrayList<>();

        int max = 0;

        for (int i = 0; i < stages.length; i++){
            if (max < stages[i])
                max = stages[i];
        }

        //stage1부터 N까지 순차적으로 순회하며 실패율 계산
        for (int i = 1; i < max+1; i++){
            if (N+1 == i)
                continue;

            int parti = 0;
            int notClear = 0;

            for (int j = 0; j < stages.length; j++) {
                if (i <= stages[j]){
                    parti++;
                }

                if (i == stages[j]){
                    notClear++;
                }
            }
            FailAndStage fs = new FailAndStage((double)notClear / parti, i);
            list.add(fs);
        }

        for (int i = 0; i < N-max; i++){
            list.add(new FailAndStage(0, N-i));
        }

        Collections.sort(list, new Sort1());
        Collections.sort(list, new Sort2());

        for (FailAndStage fs : list){
            System.out.println(fs.getFailureRate());
            System.out.println(fs.getStageNum());
        }

        ArrayList<Integer> answerList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++){
            answerList.add(list.get(i).stageNum);
        }

        answer = new int[answerList.size()];

        for (int i = 0; i < answerList.size(); i++)
            answer[i] = answerList.get(i);

        return answer;
    }

    public class FailAndStage {
        public double failureRate;
        public int stageNum;

        public FailAndStage(double fr, int sn){
            this.failureRate = fr;
            this.stageNum = sn;
        }

        public double getFailureRate(){
            return failureRate;
        }

        public int getStageNum(){
            return stageNum;
        }

        public void setFailureRate(double fr){
            this.failureRate = fr;
        }

        public void setStageNum(int sn){
            this.stageNum = sn;
        }
    }

    class Sort1 implements Comparator<FailAndStage> {
        @Override
        public int compare(FailAndStage fs1, FailAndStage fs2){
            if (fs1.failureRate == fs2.failureRate)
                return 0;
            return fs1.failureRate > fs2.failureRate ? -1 : 1;
        }
    }

    class Sort2 implements Comparator<FailAndStage> {
        @Override
        public int compare(FailAndStage fs1, FailAndStage fs2){
            if (fs1.failureRate == fs2.failureRate){
                if (fs1.stageNum == fs2.stageNum)
                    return 0;
                return fs1.stageNum > fs2.stageNum ? 1 : -1;
            }

            return 0;
        }
    }
}
