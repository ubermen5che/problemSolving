package prob16928;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class LadderSnakeGame {

    static final Integer MAX = 101;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Node[] board = new Node[MAX];

        for (int i = 1; i < MAX; i++){
            board[i] = new Node(String.valueOf(i));
        }

        for (int i = 0; i < N+M; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bf.readLine());
            Integer idx1 = Integer.parseInt(stringTokenizer.nextToken());
            Integer idx2 = Integer.parseInt(stringTokenizer.nextToken());

            board[idx1].nextNode = idx2;
        }

        bfsSearch(board);
    }

    public static void bfsSearch(Node[] board){
        ArrayList<Node> queue = new ArrayList<>();
        ArrayList<String> visited = new ArrayList<>();

        //시작 노드 삽입 후 방문처리
        queue.add(board[1]);
        visited.add(board[1].name);

        while(!queue.isEmpty()) {
            Node node = queue.remove(0);

            if (node.name.equals("100")){
                System.out.println(node.diceCnt);
                break;
            }

            Integer nodeIdx = Integer.parseInt(node.name);

            //노드의 범위가 유효범위내 일 때 유효범위의 노드들을 queue에 삽입.
            for (int i = 1; i < 7; i++) {
                if (visited.contains(String.valueOf(nodeIdx+i)) || nodeIdx+i > 100)
                    continue;

                visited.add(board[nodeIdx+i].name);

                if (board[nodeIdx+i].type == "N") {
                    queue.add(board[nodeIdx+i]);
                    board[nodeIdx+i].diceCnt = node.diceCnt + 1;
                }
                //사다리 칸일 경우 다음 방문할 노드와 연결된 노드 삽입.
                //횟수 갱신 필요시 갱신 아닐경우
                else if (board[nodeIdx+i].type == "L" || board[nodeIdx+i].type == "S") {
                    if (!visited.contains(board[board[nodeIdx+i].nextNode].name)) {
                        queue.add(board[board[nodeIdx+i].nextNode]);
                        visited.add(board[board[nodeIdx+i].nextNode].name);
                        board[board[nodeIdx+i].nextNode].diceCnt = node.diceCnt + 1;
                    }
                }
            }
        }
    }

    public static class Node {
        public Integer diceCnt;
        public String type = "N";
        public String name = "";
        public Integer nextNode;

        public Node(String name){
            this.name = name;
            this.diceCnt = 0;
        }
    }
}
