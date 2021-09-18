package programmers.level1;

import java.util.*;

class Solution {

    static int[] player1 = new int[] {1,2,3,4,5};
    static int[] player2 = new int[] {2,1,2,3,2,4,2,5};
    static int[] player3 = new int[] {3,3,1,1,2,2,4,4,5,5};
    static int[] playerScore = new int[3];
    static ArrayList<int []> playerList = new ArrayList<>();

    public int[] solution(int[] answers) {
        int[] answer = {};

        playerList.add(player1);
        playerList.add(player2);
        playerList.add(player3);

        int[] quote = new int[3];
        int[] remainder = new int[3];

        int lenOfAnswers = answers.length;

        for (int i = 0; i < 3; i++){
            quote[i] = lenOfAnswers / playerList.get(i).length;
            remainder[i] = lenOfAnswers % playerList.get(i).length;
        }

        for (int i = 0; i < 3; i++){
            int playerLen = playerList.get(i).length;
            //몫에 대한 처리
            for (int j = 0; j < quote[i] * playerLen; j++){
                if (answers[j] == playerList.get(i)[j % playerLen])
                    playerScore[i]++;
            }
            //나머지 처리

            int curIdx = quote[i] * playerLen;

            for (int k = 0; k < remainder[i]; k++){
                if (answers[curIdx+k] == playerList.get(i)[(curIdx+k) % playerLen])
                    playerScore[i]++;
            }
        }

        for (int i = 0; i < 3; i++){
            System.out.println(playerScore[i]);
        }

        int max = Math.max(Math.max(playerScore[0], playerScore[1]), playerScore[2]);

        ArrayList<Integer> list = new ArrayList<>();

        if (max == playerScore[0])
            list.add(1);
        if (max == playerScore[1])
            list.add(2);
        if (max == playerScore[2])
            list.add(3);

        int answerArr[] = new int[list.size()];

        for (int i = 0; i < answerArr.length; i++){
            answerArr[i] = list.get(i);
        }

        return answerArr;
    }
}