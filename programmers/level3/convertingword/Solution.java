package programmers.level3.convertingword;

import java.util.*;

public class Solution {

    static HashMap<String, Integer> distance;
    static HashMap<String, Boolean> visited;

    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        distance = new HashMap<>();
        visited = new HashMap<>();

        distance.put(begin, 0);

        for (int i = 0; i < words.length; i++){
            distance.put(words[i], 0);
            visited.put(words[i], false);
        }

        int numOfWords = words.length;

        answer = bfs(begin, target, words, numOfWords);

        return answer;
    }

    public static int bfs(String begin, String target, String[] words, int numOfWords){
        ArrayList<String> queue = new ArrayList<>();

        queue.add(begin);
        visited.put(begin, true);

        int resultCnt = 0;

        while(!queue.isEmpty()){
            String qStr = queue.remove(0);

            ArrayList<String> validWords = getValidList(qStr, words, numOfWords);

            if (qStr.equals(target)){
                return distance.get(target);
            }
            for (int i = 0; i < validWords.size(); i++){
                String tmp = validWords.get(i);
                if (!visited.get(tmp)){
                    queue.add(tmp);
                    Integer getDis = distance.get(qStr);
                    distance.put(tmp, getDis + 1);
                    visited.put(tmp, true);
                }
            }
        }
        return 0;
    }

    public static ArrayList<String> getValidList(String element, String[] words, int numOfWords){
        ArrayList<String> vList = new ArrayList<>();
        int cnt = 0;

        for (int i = 0; i < numOfWords; i++){
            for (int j = 0; j < element.length(); j++){
                if (words[i].charAt(j) == element.charAt(j))
                    cnt++;
            }
            if (cnt == element.length()-1)
                vList.add(words[i]);
            cnt = 0;
        }
        return vList;
    }
}
