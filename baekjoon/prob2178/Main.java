package prob2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static String target = "";

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] graphInfo = new int[N][M];


        for (int i = 0; i < N; i++) {
            String line = bf.readLine();
            for (int j = 0; j < M; j++) {
                graphInfo[i][j] = line.charAt(j) - 48;
            }
        }

        target = String.valueOf(N - 1) + "," + String.valueOf(M - 1);

        HashMap<String, ArrayList<Node>> graph = new HashMap<>();

        //graphInfo 기반 노드 생성 및 연결
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graphInfo[i][j] == 1) {
                    //노드 생상 후 상,하,좌,우 중에서 인접한 노드가 있는지 검사
                    String iStr = String.valueOf(i);
                    String jStr = String.valueOf(j);
                    graph.put(iStr + "," + jStr, new ArrayList<>());
                    //상
                    if (i - 1 >= 0) {
                        if (graphInfo[i - 1][j] == 1) {
                            String tmp = String.valueOf(i - 1);
                            graph.get(iStr + "," + jStr).add(new Node(tmp + "," + jStr));
                        }
                    }
                    //하
                    if (i + 1 < N) {
                        if (graphInfo[i + 1][j] == 1) {
                            String tmp = String.valueOf(i + 1);
                            graph.get(iStr + "," + jStr).add(new Node(tmp + "," + jStr));
                        }
                    }
                    //좌
                    if (j - 1 >= 0) {
                        if (graphInfo[i][j - 1] == 1) {
                            String tmp = String.valueOf(j - 1);
                            graph.get(iStr + "," + jStr).add(new Node(iStr + "," + tmp));
                        }
                    }
                    //우
                    if (j + 1 < M) {
                        if (graphInfo[i][j + 1] == 1) {
                            String tmp = String.valueOf(j + 1);
                            graph.get(iStr + "," + jStr).add(new Node(iStr + "," + tmp));
                        }
                    }
                }
            }
        }
        /**
        ArrayList<String> keys = new ArrayList<>();
        for (String key : graph.keySet()){
            keys.add(key);
        }
        Collections.sort(keys);
        System.out.println(keys);
         **/
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        System.out.println(bfs(graph, new Node("0,0")));
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(m) : "+secDiffTime);
    }

    public static class Node{
        public String name;
        public Integer dist;

        public Node(String name){
            this.name = name;
            this.dist = 0;
        }
    }

    //아래의 bfs가 느린이유 추정
    //1. 그래프정보를 비효율적으로 저장했음. 해당 문제는 단순히 입력받은 배열에 대해 상하좌우에 인접노드가 존재할 수 있기 때문에
    //   상하좌우 노드가 있는지만 확인하고 처리하면 더욱 빠를것임.
    public static int bfs(HashMap<String, ArrayList<Node>> graph, Node startNode){

        ArrayList<Node> queue = new ArrayList<>();
        ArrayList<String> visited = new ArrayList<>();

        startNode.dist = 1;
        queue.add(startNode);

        while(!queue.isEmpty()){
            Node node = queue.remove(0);
            if (!visited.contains(node.name)){
                if (node.name.equals(target)){
                    return node.dist;
                }
                ArrayList<Node> tmp;
                tmp = graph.get(node.name);
                for (int i = 0; i < tmp.size(); i++){
                    if (!visited.contains(tmp.get(i).name)){
                        tmp.get(i).dist = node.dist + 1;

                        if (tmp.get(i).name.equals(target))
                            return tmp.get(i).dist;

                    } else {
                        tmp.remove(i);
                        i--;
                    }
                }
                queue.addAll(tmp);
                visited.add(node.name);
            }
        }
        return 0;
    }
}
