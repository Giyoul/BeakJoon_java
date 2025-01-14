import java.io.*;

public class Main {
    public static Node root;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        root = new Node(Integer.parseInt(br.readLine()));

        while(true){
            String s = br.readLine();
            if(s == null || s.equals("")) break;

            int data = Integer.parseInt(s);
            root.insert(data);
        }

        show(root);
    }

    public static class Node{
        public Node left, right;
        public int data;

        public Node(int data){
            this.data = data;
            this.left = this.right = null;
        }

        public void insert(int data){
            if (this.data > data) {
                if (this.left == null) {
                    this.left = new Node(data);
                } else {
                    this.left.insert(data);
                }
            } else {
                if (this.right == null) {
                    this.right = new Node(data);
                } else {
                    this.right.insert(data);
                }
            }
        }
    }

    public static void show(Node n) {
        if(n == null) return;
        show(n.left);
        show(n.right);
        System.out.println(n.data);
    }
}