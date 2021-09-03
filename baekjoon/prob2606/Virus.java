package prob2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Virus {

    static Integer cnt = -1;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int E = Integer.parseInt(bf.readLine());

        HashMap<Integer, LinkedList<Integer>> graph = new HashMap<>();

        //노드 생성
        for (int i = 0; i < N; i++){
            graph.put(i+1, new LinkedList<>());
        }

        //노드 연결
        for (int i = 0; i < E; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            Integer nodeA = Integer.parseInt(st.nextToken());
            Integer nodeB = Integer.parseInt(st.nextToken());

            graph.get(nodeA).add(nodeB);
            graph.get(nodeB).add(nodeA);
        }

        bfs(graph);

        System.out.println(cnt);
    }

    public static void bfs(HashMap<Integer, LinkedList<Integer>> graph){
        LinkedList<Integer> queue = new LinkedList<>();
        ArrayList<Integer> visited = new ArrayList<>();

        Integer startNode = 1;

        queue.offer(startNode);

        while(!queue.isEmpty()){
            Integer node = queue.poll();
            if (!visited.contains(node)){
                cnt++;
                visited.add(node);
                queue.addAll(graph.get(node));
            }
        }
    }
}
