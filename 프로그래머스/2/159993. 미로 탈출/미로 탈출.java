import java.util.Arrays;
import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    class Node {
        int positionX;
        int positionY;
        int passedDistance;
        
        public Node(int positionX, int positionY, int passedDistance) {
            this.positionX = positionX;
            this.positionY = positionY;
            this.passedDistance = passedDistance;
        }
    }
    
    boolean[][] canMove;
    Node startPosition;
    Node leverPosition;
    Node endPosition;
    int width;
    int height;
    
    public int solution(String[] maps) {
        height = maps.length;
        width = maps[0].length();
        canMove = new boolean[height][width]; 
        
        for(int positionY = 0; positionY < height; positionY++) {
            for(int positionX = 0; positionX < width; positionX++) {
                char value = maps[positionY].charAt(positionX);
                
                if(value == 'X') continue;
                canMove[positionY][positionX] = true;
                
                if(value == 'S') startPosition = new Node(positionX, positionY, 0);
                if(value == 'L') leverPosition = new Node(positionX, positionY, 0);
                if(value == 'E') endPosition = new Node(positionX, positionY, 0);
            }
        }
        
        int startToLever = calulateDistance(startPosition, leverPosition);
        if(startToLever == -1) return -1;
        
        int leverToExit = calulateDistance(leverPosition, endPosition);
        if(leverToExit == -1) return -1;
    
        return startToLever + leverToExit;
    }
    
    private int calulateDistance(Node from, Node to) {
        int[][] distanceMap = new int[height][width];
        int[] directionX = new int[] {-1, 1, 0, 0};
        int[] directionY = new int[] {0, 0, -1, 1};
        
        Deque<Node> bfsDeque = new ArrayDeque<>();
        
        for(int i = 0; i < height; i++) {
            Arrays.fill(distanceMap[i], Integer.MAX_VALUE);
        }
        
        bfsDeque.addLast(new Node(from.positionX, from.positionY, 0));
        
        while(!bfsDeque.isEmpty()) {
            Node currentNode = bfsDeque.removeFirst();
            int currentX = currentNode.positionX;
            int currentY = currentNode.positionY;
            int moveCount = currentNode.passedDistance;
            
            for(int position = 0; position < 4; position++) {
                int newX = currentX + directionX[position];
                int newY = currentY + directionY[position];
                int newMoveCount = moveCount + 1;
                
                if(newX < 0 || newX >= width || newY < 0 || newY >= height || !canMove[newY][newX]) continue;
                
                if(distanceMap[newY][newX] > newMoveCount) {
                    distanceMap[newY][newX] = newMoveCount;
                    bfsDeque.addLast(new Node(newX, newY, newMoveCount));
                }
            }
        }
        
        if(distanceMap[to.positionY][to.positionX] == Integer.MAX_VALUE) return -1;
        return distanceMap[to.positionY][to.positionX];
    }
}