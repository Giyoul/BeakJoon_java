import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    static class Node implements Comparable<Node> {
        int index;
        int x, y;
        Node left, right;
        
        Node(int i, int x, int y) {
            this.index = i;
            this.x = x;
            this.y = y;
        }
        
        @Override
        public int compareTo(Node other) {
            if(this.y != other.y) {
                return Integer.compare(other.y, this.y);
            }
            
            return Integer.compare(this.x, other.x);
        }
    }
    
    int[][] result;
    int preIdx = 0;
    int postIdx = 0;
    
    public int[][] solution(int[][] nodeinfo) {
        int n = nodeinfo.length;
        List<Node> nodes = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            nodes.add(new Node(i+1, nodeinfo[i][0], nodeinfo[i][1]));
        }
        
        Collections.sort(nodes);
        
        Node root = nodes.get(0);
        for(int i = 1; i < n; i++) {
            insertNode(root, nodes.get(i));
        }
        
        result = new int[2][n];
        preorder(root);
        postorder(root);
        
        return result;
    }
    
    private void insertNode(Node parent, Node child) {
        if (child.x < parent.x) {
            if (parent.left == null) {
                parent.left = child;
            } else {
                insertNode(parent.left, child);
            }
        } 

        else {
            if (parent.right == null) {
                parent.right = child;
            } else {
                insertNode(parent.right, child);
            }
        }
    }
    
    private void preorder(Node node) {
        if (node == null) return;
        result[0][preIdx++] = node.index;
        preorder(node.left);
        preorder(node.right);
    }

    private void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        result[1][postIdx++] = node.index;
    }
}