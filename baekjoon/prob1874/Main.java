package prob1874;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] inputArr = new String[N];

        ArrayList<Integer> sortedInput = new ArrayList<>();
        ArrayList<Integer> stack = new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < N; i++){
            inputArr[i] = br.readLine();
            sortedInput.add(Integer.parseInt(inputArr[i]));
        }

        Collections.sort(sortedInput);

        int offset = Integer.parseInt(inputArr[0]) - sortedInput.get(0);
        int indicator = 0;
        int count = 0;

        for (int i = 0; i < offset+1; i++){
            stack.add(sortedInput.get(i));
            result.add("+");
        }

        indicator = stack.get(stack.size()-1);

        while(N > count){
            if (stack.isEmpty()){
                offset = Integer.parseInt(inputArr[count]) - indicator;
                for (int i = 0; i < offset; i++){
                    stack.add(indicator + (i + 1));
                    result.add("+");
                }
                indicator += offset;
            }
            if (stack.get(stack.size()-1) == Integer.parseInt(inputArr[count])){
                result.add("-");
                stack.remove(stack.size()-1);
                count++;
            }else {
                //스택의 최상위 값이 inputArr보다 큰경우
                if (stack.get(stack.size()-1) > Integer.parseInt(inputArr[count])) {
                    System.out.println("NO");
                    return;
                }
                else {
                    int diff = Integer.parseInt(inputArr[count]) - indicator;

                    for (int i = 0; i < diff; i++){
                        stack.add(indicator + (i + 1));
                        result.add("+");
                    }
                    indicator += diff;
                }
            }
        }
        for (String r : result){
            System.out.println(r);
        }
    }
}
