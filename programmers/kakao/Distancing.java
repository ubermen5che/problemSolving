package programmers.kakao;

class Distancing {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];

        for (int i = 0; i < 5; i++){
            answer[i] = solution2(places[i]);
        }

        return answer;
    }

    public static int solution2(String[] place){
        String map[][] = convertToTwoDimArr(place);

        for (int i = 0; i < map.length; i++){
            for (int j = 0; j < map[i].length; j++){

                int sum = map[i][j].equals("P") ? 1: 0;          //자기 자신이 P면 1부터 시작

                if(map[i][j].equals("X")) continue;

                //상
                if (i-1 >= 0){
                    if (map[i-1][j].equals("P"))
                        sum++;
                }

                //하
                if (i + 1 < 5){
                    if (map[i+1][j].equals("P")){
                        sum++;
                    }
                }

                //좌
                if (j - 1 >= 0){
                    sum += map[i][j-1].equals("P") ? 1 : 0;
                }

                if (j + 1 < 5){
                    sum += map[i][j+1].equals("P") ? 1 : 0;
                }

                if (sum >= 2){
                    System.out.println(sum);
                    return 0;
                }
            }
        }
        return 1;
    }

    public static String[][] convertToTwoDimArr(String[] place){
        String[][] map = new String[5][5];

        for (int i = 0; i < place.length; i++){
            String line = place[i];
            for (int j = 0; j < place[0].length(); j++){
                map[i][j] = line.charAt(j) + "";
            }
        }

        return map;
    }
}
