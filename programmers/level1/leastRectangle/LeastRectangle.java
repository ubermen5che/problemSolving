package programmers.level1.leastRectangle;

public class LeastRectangle {

    class Solution {
        public int solution(int[][] sizes) {

            int maxW = 0;
            int maxH = 0;

            for (int i = 0; i < sizes.length; i++){
                for (int j = 0; j < sizes[i].length; j++){
                    //가로
                    if (j == 0){
                        if (maxW < sizes[i][j])
                            maxW = sizes[i][j];
                    } else  //세로
                        if (maxH < sizes[i][j])
                            maxH = sizes[i][j];
                }
            }

            int answer = 0;
            int offset = maxW - maxH;
            int answerVar = 0;

            //swap이 일어나는 부분
            //offset이 음수일 경우(가로 < 세로)
            if (offset < 0){
                int arrOffSet = 0;
                answerVar = maxH;
                for (int i = 0; i < sizes.length; i++){
                    arrOffSet = sizes[i][0] - sizes[i][1];
                    if (arrOffSet > 0){
                        int tmp = 0;
                        tmp = sizes[i][0];
                        sizes[i][0] = sizes[i][1];
                        sizes[i][1] = tmp;
                    } else
                        continue;
                }
                int realMax = 0;

                for (int i = 0; i < sizes.length; i++){
                    if (sizes[i][0] > realMax)
                        realMax = sizes[i][0];
                }

                return answerVar * realMax;

            } else {    //offset이 양수일 경우(가로 > 세로)
                int arrOffSet = 0;
                answerVar = maxW;
                for (int i = 0; i < sizes.length; i++){
                    arrOffSet = sizes[i][0] - sizes[i][1];
                    if (arrOffSet < 0){
                        int tmp = 0;
                        tmp = sizes[i][0];
                        sizes[i][0] = sizes[i][1];
                        sizes[i][1] = tmp;
                    } else
                        continue;
                }
                int realMax = 0;

                for (int i = 0; i < sizes.length; i++){
                    if (sizes[i][1] > realMax)
                        realMax = sizes[i][1];
                }

                return answerVar * realMax;
            }
        }
    }
}
