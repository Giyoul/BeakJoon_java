import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;

class Solution {
    public int solution(int[][] maps) {
        int width = maps[0].length;
        int height = maps.length;
        
        int[] dirX = {0, 1, 0, -1};
        int[] dirY = {-1, 0, 1, 0};
        int[][] map = new int[height][width];
        for(int[] row : map) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        Queue<Node> queue = new LinkedList();
        
        map[0][0] = 1;
        queue.add(new Node(0, 0, 1));
        
        while(!queue.isEmpty()){
            Node currentNode = queue.poll();
                
            for(int i = 0; i < 4; i++){
                int newPosX = currentNode.posX + dirX[i];
                int newPosY = currentNode.posY + dirY[i];
                
                if(newPosX >= 0 && newPosX < width && newPosY >= 0 && newPosY < height && maps[newPosY][newPosX] == 1) {
                    if(map[newPosY][newPosX] > currentNode.count + 1){
                        queue.add(new Node(newPosY, newPosX, currentNode.count + 1));
                        map[newPosY][newPosX] = currentNode.count + 1;
                    }
                }
            }
        }
        
        if(map[height - 1][width - 1] == Integer.MAX_VALUE){
            return -1;
        }
        return map[height - 1][width - 1];
    }
    
    class Node{
        int posY;
        int posX;
        int count;
        
        public Node(int posY, int posX, int count){
            this.posY = posY;
            this.posX = posX;
            this.count = count;
        }
    }
}