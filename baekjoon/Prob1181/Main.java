package Prob1181;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        class StringLengthCompare implements Comparator<String>{

            @Override
            public int compare(String o1, String o2) {
                if(o1.length() > o2.length())
                    return 1;
                else if(o1.length() < o2.length())
                    return -1;
                else
                    return 0;
            }
        }

        List<String> inputStrings = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for(int i = 0; i < N; i++){
            String tmp = sc.next();
            if (!inputStrings.contains(tmp))
                inputStrings.add(tmp);
        }

        Collections.sort(inputStrings);
        Collections.sort(inputStrings, new StringLengthCompare());

        for (String element : inputStrings){
            System.out.println(element);
        }
    }
}
