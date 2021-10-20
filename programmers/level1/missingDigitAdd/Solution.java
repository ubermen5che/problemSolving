package programmers.level1.missingDigitAdd;

/**
 * 배열에 1~9사이의 숫자가 입력되는데, 배열에 존재하지 않는 숫자를 확인해서 없는 숫자를 모두 더하는 아주 간단한 문제.
 * boolean 배열을 10개 두고 0~9숫자의 존재 상태를 저장하고 false를 가지는 배열의 index를 더해주는 방식으로 구현.
 */
class Solution {
    public int solution(int[] numbers) {
        int answer = 0;

        boolean[] check = new boolean[10];

        for (int i = 0; i < numbers.length; i++){
            check[numbers[i]] = true;
        }

        for (int i = 0; i < check.length; i++){
            if (check[i] == false)
                answer += i;
        }

        return answer;
    }
}
