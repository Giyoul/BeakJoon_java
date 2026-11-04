import java.util.Arrays;
import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    private final int[] directionX = {1, -1, 0, 0};
    private final int[] directionY = {0, 0, 1, -1};
    private char[][] map;
    private int[][] minCountMap;
    private int width;
    private int height;
    
    private class Node {
        int x;
        int y;
        int stepCount;
        
        public Node(int x, int y, int stepCount) {
            this.x = x;
            this.y = y;
            this.stepCount = stepCount;
        }
    }
    
    public int solution(String[] board) {
        width = board[0].length();
        height = board.length;
        map = new char[height][width];
        minCountMap = new int[height][width];
        
        int startX = -1;
        int startY = -1;
        int finishX = -1;
        int finishY = -1;
        
        for(int boardHeight = 0; boardHeight < height; boardHeight++) {
            Arrays.fill(minCountMap[boardHeight], Integer.MAX_VALUE);
            for(int boardWidth = 0; boardWidth < width; boardWidth++) {
                char boardValue = board[boardHeight].charAt(boardWidth);
                
                if(boardValue == 'R') {
                    startX = boardWidth;
                    startY = boardHeight;
                }
                
                if(boardValue == 'G') {
                    finishX = boardWidth;
                    finishY = boardHeight;
                }
                
                map[boardHeight][boardWidth] = boardValue;
            }
        }
        
        updateMinCountMap(startX, startY, finishX, finishY);
        
        if(minCountMap[finishY][finishX] == Integer.MAX_VALUE) return -1;
        return minCountMap[finishY][finishX];
    }
    
    private void updateMinCountMap(int startX, int startY, int finishX, int finishY){
        Queue<Node> bfsQueue = new ArrayDeque<>();
        bfsQueue.offer(new Node(startX, startY, 0));
        minCountMap[startY][startX] = 0;
        
        while(!bfsQueue.isEmpty()) {
            Node currentNode = bfsQueue.poll();
            
            for(int direction = 0; direction < 4; direction++) {
                int newX = currentNode.x + directionX[direction];
                int newY = currentNode.y + directionY[direction];
                
                while(newX >= 0 && newX < width && newY >= 0 && newY < height) {
                    if(map[newY][newX] == 'D') break;
                    
                    newX = newX + directionX[direction];
                    newY = newY + directionY[direction];
                }
                
                newX -= directionX[direction];
                newY -= directionY[direction];
                
                if(minCountMap[newY][newX] > currentNode.stepCount + 1) {
                    bfsQueue.offer(new Node(newX, newY, currentNode.stepCount + 1));
                    minCountMap[newY][newX] = currentNode.stepCount + 1;
                }
            }
        }
    }
}