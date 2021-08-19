package prob1259;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> inputList = new ArrayList<>();

        while(true){
            int input = sc.nextInt();

            if (input == 0)
                break;
            else
                inputList.add(input);
        }

        for (Integer input : inputList){
            if (isPalindrome(input))
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }

    public static boolean isPalindrome(int input){
        String sNum = String.valueOf(input);
        ArrayList<Character> stack = new ArrayList<>();
        //숫자 길이가 짝수일 경우
        if (sNum.length() % 2 == 0){
            //반 잘라서 스택에 넣는다.
            for (int i = 0; i < sNum.length() / 2; i++){
                stack.add(sNum.charAt(i));
            }

            Boolean flag = true;
            //나머지 반절과 스택에 저장되어있는 문자 비교
            for (int i = sNum.length() / 2; i < sNum.length(); i++){
                Character charInStack = stack.get(stack.size()-1);
                if (!charInStack.equals(sNum.charAt(i)))
                    flag = false;
                stack.remove(stack.size()-1);
            }
            return flag;
        }
        //숫자 길이가 홀수일 경우
        //String의 길이를 2로 나눈 몫의 크기만큼 stack에 넣는다. ex) 7 / 2 = 3 ... 1
        //가운데 문자는 상관없으므로 그 이후에 Char들에 대해서 검사한다. ex) [abcdcba] abc cba만 검사
        else{
            for (int i = 0; i < sNum.length() / 2; i++){
                stack.add(sNum.charAt(i));
            }

            Boolean flag = true;

            for (int i = (sNum.length() / 2) + 1; i < sNum.length(); i++){
                Character charInStack = stack.get(stack.size()-1);

                if (!charInStack.equals(sNum.charAt(i)))
                    flag = false;
                stack.remove(stack.size()-1);
            }

            return flag;
        }
    }
}
