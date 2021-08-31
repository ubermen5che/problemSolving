package prob1991;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        Node head = null;
        Node root = new Node();

        root.setName("A");
        head = root;

        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());

            Node node;
            String tmp = st.nextToken();
            node = searchNode(head, tmp);
            //노드가 존재하지 않는다면 생성 후 자식과 연결
            if (node == null) {
                node = new Node(tmp);
            }
            String tmpLeft = st.nextToken();
            String tmpRight = st.nextToken();

            //왼, 오 자식 둘다 . 이면 연결 필요 x
            if (tmpLeft.equals(".") || tmpRight.equals(".")){
                if (tmpLeft.equals(".") && tmpRight.equals(".")) {
                }
                else if (tmpLeft.equals(".")){
                    node.rightChild = new Node(tmpRight);
                } else if (tmpRight.equals(".")){
                    node.leftChild = new Node(tmpLeft);
                }
            } else {
                node.leftChild = new Node(tmpLeft);
                node.rightChild = new Node(tmpRight);
            }
        }

        printPreOrder(head);
        System.out.println();
        printInOrder(head);
        System.out.println();
        printPostOrder(head);
        System.out.println();
    }

    static class Node {
        private String name;
        private Node leftChild;
        private Node rightChild;

        public Node(){
            name = null;
            leftChild = null;
            rightChild = null;
        }
        public Node(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Node getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }

        public Node getRightChild() {
            return rightChild;
        }

        public void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }
    }

    public static Node searchNode(Node node, String name){
        if (node == null)
            return null;
        else {
            if (node.getName().equals(name))
                return node;
            Node tmp1;
            Node tmp2;

            tmp1 = searchNode(node.leftChild, name);
            if (tmp1 != null)
                return tmp1;
            tmp2 = searchNode(node.rightChild, name);
            if (tmp2 != null)
                return tmp2;
        }
        return null;
    }

    public static void printPreOrder(Node node){
        if (node == null)
            return;
        else {
            System.out.print(node.getName());
            printPreOrder(node.leftChild);
            printPreOrder(node.rightChild);
        }
    }

    public static void printInOrder(Node node){
        if (node == null)
            return;
        else {
            printInOrder(node.leftChild);
            System.out.print(node.getName());
            printInOrder(node.rightChild);
        }
    }

    public static void printPostOrder(Node node){
        if (node == null)
            return;
        else {
            printPostOrder(node.leftChild);
            printPostOrder(node.rightChild);
            System.out.print(node.getName());
        }
    }
}
