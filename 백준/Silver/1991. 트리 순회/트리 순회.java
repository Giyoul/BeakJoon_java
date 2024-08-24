import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static node[] arr = new node[26];
    static StringBuilder sb = new StringBuilder();

    public static class node {
        char cur;
        node left;
        node right;

        public node(char cur) {
            this.cur = cur;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            char token = st.nextToken().charAt(0);

            if (arr[token - 'A'] == null) {
                arr[token - 'A'] = new node(token);
            }

            char left = st.nextToken().charAt(0);
            if (left != '.') {
                arr[left - 'A'] = new node(left);
                arr[token - 'A'].left = arr[left - 'A'];
            }

            char right = st.nextToken().charAt(0);
            if (right != '.') {
                arr[right - 'A'] = new node(right);
                arr[token - 'A'].right = arr[right - 'A'];
            }
        }

        preorder(arr[0]);
        sb.append("\n");
        inorder(arr[0]);
        sb.append("\n");
        postorder(arr[0]);
        sb.append("\n");

        System.out.print(sb);
    }

    public static void preorder(node current) {
        if(current.left == null && current.right == null) {
            sb.append(current.cur);
            return;
        }

        sb.append(current.cur);
        if(current.left != null) {
            preorder(current.left);
        }
        if(current.right != null) {
            preorder(current.right);
        }
    }

    public static void postorder(node current) {
        if(current.left == null && current.right == null) {
            sb.append(current.cur);
            return;
        }

        if(current.left != null) {
            postorder(current.left);
        }
        if(current.right != null) {
            postorder(current.right);
        }
        sb.append(current.cur);
    }

    public static void inorder(node current) {
        if(current.left == null && current.right == null) {
            sb.append(current.cur);
            return;
        }

        if(current.left != null) {
            inorder(current.left);
        }
        sb.append(current.cur);
        if(current.right != null) {
            inorder(current.right);
        }
    }
}
