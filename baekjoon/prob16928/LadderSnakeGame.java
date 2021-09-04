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

            Integer r = idx1 / 10;
            Integer c = idx1 % 10;

            //사다리인 경우 ex) 32 62
            if (idx1 < idx2){
                board[idx1].type = "L";
            } else {
                board[idx1].type = "S";
            } board[idx1].nextNode = idx2;
        }

        bfsSearch(board);
    }

    public static class Node {
        public Integer diceCnt;
        public String type = "N";
        public String name = "";
        public Integer nextNode;

        public Node(String name){
            this.name = name;
            this.diceCnt = 999;
        }
    }

    public static void bfsSearch(Node[] board){
        ArrayList<Node> queue = new ArrayList<>();
        ArrayList<String> visited = new ArrayList<>();

        queue.add(board[1]);

        while(!queue.isEmpty()){
            Node node = queue.remove(0);
            visited.add(node.name);

            Integer nodeIdx = Integer.parseInt(node.name);

            if (nodeIdx > 94 && nodeIdx <= 99 || nodeIdx == 100){
                if (nodeIdx == 100) {
                    System.out.println(node.diceCnt);
                    break;
                }
                else {
                    System.out.println(node.diceCnt + 1);
                    break;
                }
            }

            //노드의 범위가 유효범위내 일 때 유효범위의 노드들을 queue에 삽입.
            for (int i = nodeIdx + 1; i < nodeIdx + 7; i++) {
                queue.add(board[i]);

                if (board[i].type == "N"){
                }
                //사다리 칸일 경우 다음 방문할 노드와 연결된 노드 삽입.
                else if (board[i].type == "L"){
                    board[board[i].nextNode].diceCnt = node.diceCnt + 1;
                    queue.add(board[board[i].nextNode]);
                }
                //뱀칸 일 경우
                else{
                    board[]
                    queue.add(board[board[i].nextNode]);
                    //queue.add(board[nodeIdx+1]);
                }
            }
                //현재 범위내에 노드들 큐에넣고 type체크해서 큐에 추가로 넣는 부분.
                if (nodeIdx % 6 == 1 && nodeIdx < 99) {
                    for (int i = nodeIdx + 1; i < nodeIdx + 7; i++) {
                        if (i < MAX) {
                            //이전에 사다리로 인해 방문하지 않은 노드라면 diceCnt == 0일 것이다.
                            if (board[i].diceCnt == 999)
                                board[i].diceCnt = count;
                            queue.add(board[i]);
                        } else
                            continue;

                        //사다리, 뱀칸도 아닌경우
                        //다음에 방문할 노드를 큐에 삽입.
                        if (board[i].type == "N"){
                        }
                        //사다리 칸일 경우 다음 방문할 노드와 연결된 노드 삽입.
                        else if (board[i].type == "L"){
                            //현재 노드의 위치에서 도달 불가능한 노드이면
                            if (board[i].nextNode > range){
                                board[board[i].nextNode].diceCnt = count;
                            }
                            queue.add(board[board[i].nextNode]);
                        }
                        //뱀칸 일 경우
                        else{
                            queue.add(board[board[i].nextNode]);
                            //queue.add(board[nodeIdx+1]);
                        }
                    }
                } else {

                }
            }
        }
    }
}
