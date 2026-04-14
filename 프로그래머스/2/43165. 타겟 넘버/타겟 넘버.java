import java.util.Queue;
import java.util.ArrayDeque;

class Solution {
    public int solution(int[] numbers, int target) {
        int maxDepth = numbers.length;
        int answer = 0;
        Queue<Node> queue = new ArrayDeque();
        queue.add(new Node(0, 0));
        
        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(node.depth == maxDepth){
                if(node.sum == target){
                    answer++;
                }
                continue;
            }
            queue.add(new Node(node.depth + 1, node.sum + numbers[node.depth]));
            queue.add(new Node(node.depth + 1, node.sum - numbers[node.depth]));
        }
        
        return answer;
    }
    
    public class Node {
        public int depth;
        public int sum;
        
        public Node(int depth, int sum) {
            this.depth = depth;
            this.sum = sum;
        }
    }
}