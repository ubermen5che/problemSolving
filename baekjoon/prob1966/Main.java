package prob1966;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Integer[] docNum = new Integer[N];
        Integer[] interestDocPos = new Integer[N];
        List<ArrayList<Integer>> queues = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            ArrayList<Integer> queue = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());

            docNum[i] = Integer.parseInt(st.nextToken());
            interestDocPos[i] = Integer.parseInt(st.nextToken());

            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int numOfToken = st2.countTokens();
            for (int j = 0; j < numOfToken; j++) {
                queue.add(Integer.parseInt(st2.nextToken()));
            }
            queues.add(queue);
        }

        for (int i = 0; i < N; i++) {
            ArrayList<Integer> tmp = queues.get(i);
            ArrayList<Boolean> syncTmp = makeSyncList(tmp, interestDocPos[i]);

            Integer interestObject = tmp.get(interestDocPos[i]);
            Integer cnt = 1;

            while (!tmp.isEmpty()) {
                if (isPrior(tmp)) {
                    if (syncTmp.get(0)){
                        System.out.println(cnt);
                        break;
                    }
                    tmp.remove(0);
                    syncTmp.remove(0);
                    cnt++;
                }else {
                    //가장 앞에있는 값을 뒤로 보내야함.
                    Integer tmpInt = tmp.get(0);
                    Boolean tmpBool = syncTmp.get(0);

                    tmp.remove(0);
                    tmp.add(tmpInt);

                    syncTmp.remove(0);
                    syncTmp.add(tmpBool);
                }
            }
        }
    }
    public static boolean isPrior(ArrayList<Integer> queue){
        Integer head = queue.get(0);
        for (Integer element : queue){
            if (head < element)
                return false;
        }
        return true;
    }

    public static ArrayList<Boolean> makeSyncList(ArrayList<Integer> tmp, Integer interestPos){
        ArrayList<Boolean> syncArray = new ArrayList<>();

        for (int i = 0; i < tmp.size(); i++){
            syncArray.add(false);
        }

        syncArray.set(interestPos, true);

        return syncArray;
    }
}
