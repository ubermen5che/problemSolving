package baekjoon.prob1145;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Boolean flag[] =  new Boolean[5];
        Integer input[] = new Integer[5];
        int multiple = 1;
        Main main = new Main();

        Scanner keyboard = new Scanner(System.in);

        for(int i = 0; i < 5; i++){
            input[i] = keyboard.nextInt();
            flag[i] = false;
        }

        while(true){
            for(int i = 0; i < input.length; i++){
                if(multiple % input[i] == 0)
                    flag[i] = true;
            }

            if(main.checkFlag(flag) >= 3)
                break;

            for(int i = 0; i < input.length; i++)
                flag[i] = false;

            multiple++;
        }

        System.out.println(multiple);
    }

    public int checkFlag(Boolean flag[]){
        int cnt = 0;

        for(int i = 0; i < flag.length; i++){
            if(flag[i] == true)
                cnt++;
        }
        return cnt;
    }
}
