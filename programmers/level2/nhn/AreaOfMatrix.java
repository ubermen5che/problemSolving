package programmers.level2.nhn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 문제 간단 설명
 * input으로 map의 크기 N과 0과 1로 이루어진 NxN 배열이 주어짐.
 * ex ) 3
 *      1 0 0
 *      0 1 1
 *      0 1 1
 *
 * 이 때 1로 채워진 영역의 갯수와 크기를 return해야하는 문제.
 * 위의 예시에는 아래와 같이 출력되어야함.
 * 2 (영역 갯수)
 * 1 4  (영역의 크기 : 오름차순)
 *
 * 해결 방법
 * NxN 배열을 전부 순회하면서 bfs search실행. bfs함수는 해당 영역의 크기를 return하도록 만듬.
 * 그러면 각 배열의 원소를 탐색할때마다 인접한 상,하,좌,우의 1을 bfs로 탐색하게되어 넓이를 얻을 수 있음.
 * 그러면 해당 넓이를 list에 저장해놓고 오름차순 정렬하면 답나옴. 영역의 갯수의 경우도 손쉽게 cnt변수하나로 구하기 가능.
 */
public class AreaOfMatrix {
    static boolean[][] visited;
    static int[] dx = new int[] {1, -1, 0, 0};
    static int[] dy = new int[] {0, 0, -1, 1};

    private static void solution(int sizeOfMatrix, int[][] matrix) {
        // TODO: 이곳에 코드를 작성하세요.
        visited = new boolean[sizeOfMatrix][sizeOfMatrix];
        ArrayList<Integer> sizeList = new ArrayList<>();

        int areaCnt = 0;

        for (int i = 0; i < sizeOfMatrix; i++){
            for (int j = 0; j < sizeOfMatrix; j++){
                if (!visited[i][j] && matrix[i][j] == 1){
                    int areaSize;
                    areaCnt++;
                    areaSize = bfs(i,j,matrix);
                    if ( areaSize > 0){
                        sizeList.add(areaSize); //bfs리턴값(각 area크기)은 sizeList에 저장. 추후 이것을 정렬하여 출력.
                    }
                }
            }
        }

        if (areaCnt == 0){
            System.out.println(0);
            return;
        }

        Collections.sort(sizeList);
        System.out.println(areaCnt);
        String st = "";
        for (int i = 0; i < sizeList.size()-1; i++){
            System.out.print(sizeList.get(i) + " ");
        }
        System.out.println(sizeList.get(sizeList.size()-1));
    }

    public static int bfs(int x, int y, int [][] matrix) {
        ArrayList<int[]> queue = new ArrayList<>();
        int[] xy;
        int sizeCnt = 0;

        //0,0부터 인접한 영역 검사
        queue.add(new int[] {x,y});

        while(!queue.isEmpty()){
            xy = queue.remove(0);

            //방문하지 않았으면서 해당 cell이 1인경우는 인접영역을 검사해서 cnt
            if(!visited[xy[0]][xy[1]] && matrix[xy[0]][xy[1]] == 1){
                sizeCnt++;
                visited[xy[0]][xy[1]] = true;
                //아래에 코드부터는 상,하,좌,우 검사해서 방문가능한 노드 queue에 append
                int dirX, dirY;

                for(int i = 0; i < 4; i++){
                    dirX = xy[0] + dx[i];
                    dirY = xy[1] + dy[i];

                    //유효 범위 체크한 후 1인지 0인지 체크
                    if ((dirX >= 0 && dirX < matrix[0].length) && (dirY >= 0 && dirY < matrix[0].length)){
                        if (matrix[dirX][dirY] != 0 && !visited[dirX][dirY]){
                            queue.add(new int[] {dirX, dirY});
                        }
                    }
                }
            }
        }
        return sizeCnt;
    }

    private static class InputData {
        int sizeOfMatrix;
        int[][] matrix;
    }

    private static InputData processStdin() {
        InputData inputData = new InputData();

        try (Scanner scanner = new Scanner(System.in)) {
            inputData.sizeOfMatrix = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

            inputData.matrix = new int[inputData.sizeOfMatrix][inputData.sizeOfMatrix];
            for (int i = 0; i < inputData.sizeOfMatrix; i++) {
                String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
                for (int j = 0; j < inputData.sizeOfMatrix; j++) {
                    inputData.matrix[i][j] = Integer.parseInt(buf[j]);
                }
            }
        } catch (Exception e) {
            throw e;
        }

        return inputData;
    }

    public static void main(String[] args) throws Exception {
        InputData inputData = processStdin();

        solution(inputData.sizeOfMatrix, inputData.matrix);
    }
}