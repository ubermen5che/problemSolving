package baekjoon.prob1059;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        ArrayList<Integer> elementList = new ArrayList<>();
        HashMap<String, Integer> adjacentInfo = new HashMap<>();

        Main main = new Main();
        int numOfElement = keyboard.nextInt();
        keyboard.nextLine();
        String elementOfS = keyboard.nextLine();
        Integer N = keyboard.nextInt();

        StringTokenizer stringTokenizer = new StringTokenizer(elementOfS, " ");

        for (int i = 0; i < numOfElement; i++){
            elementList.add(Integer.parseInt(stringTokenizer.nextToken()));
        }

        Collections.sort(elementList);
        adjacentInfo = main.findAdjacentNum(elementList, N);

        Integer leftMargin = N - adjacentInfo.get("left");
        Integer rightMargin = adjacentInfo.get("right") - N;

        //case1: 왼쪽, 오른쪽 범위 모두 N과 겹칠경우
        if (leftMargin == 0 && rightMargin == 0 || leftMargin == 1 && rightMargin == 1){
            System.out.println(0);
        } else if (leftMargin == 1){
            System.out.println(rightMargin - 1);
        } else if (rightMargin == 1) {
            System.out.println(leftMargin - 1);
        }
        else {
            Integer result = 0;
            result = ((leftMargin-1) * rightMargin) + (1 * (rightMargin-1));
            System.out.println(result);
        }
    }

    public HashMap<String, Integer> findAdjacentNum(ArrayList<Integer> elementList, Integer N) {
        HashMap<String, Integer> adjacentInfo = new HashMap<>();
        Integer largestLeftValue = -1;
        Integer smallestRightValue = 1000000;

        for (Integer element : elementList) {
            if (element == N.intValue()) {
                adjacentInfo.put("left", element);
                adjacentInfo.put("right", element);
                return adjacentInfo;
            } else if (element < N && largestLeftValue < element) {
                largestLeftValue = element;
            } else if (element > N && smallestRightValue > element) {
                smallestRightValue = element;
            }
        }

        if (largestLeftValue < 0)
            largestLeftValue = 0;

        adjacentInfo.put("left", largestLeftValue);
        adjacentInfo.put("right", smallestRightValue);

        return adjacentInfo;
    }
}
