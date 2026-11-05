import java.util.Objects;
import java.util.Map;
import java.util.HashMap;

class Solution {
    private class Position {
        int x;
        int y;
        private int time;
        
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
            this.time = 0;
        }
        
        public Position(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
        
        public void modeTo(Position position) {
            if(this.y < position.y) {
                this.y++;
            } else if(this.y > position.y) {
                this.y--;
            } else if(this.x < position.x) {
                this.x++;
            } else if(this.x > position.x) {
                this.x--;
            }
            
            time++;
        }
        
        @Override
        public boolean equals(Object o) {
            if(this == o) return true;
            if(o == null || getClass() != o.getClass()) return false;
            Position comparePosition = (Position) o;
            return time == comparePosition.time && x == comparePosition.x && y == comparePosition.y;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(x, y, time);
        }
    }
    
    public int solution(int[][] points, int[][] routes) {
        Map<Position, Integer> routeCountMap = new HashMap<>();
        
        for (int[] route : routes) {
            int[] start = points[route[0] - 1];
            int startR = start[0];
            int startC = start[1]; 
            
            Position current = new Position(startC, startR);
            
            Position startRecord = new Position(current.x, current.y, current.time);
            routeCountMap.put(startRecord, routeCountMap.getOrDefault(startRecord, 0) + 1);
            
            for (int i = 1; i < route.length; i++) {
                int[] target = points[route[i] - 1];
                int targetR = target[0];
                int targetC = target[1];
                
                Position targetPos = new Position(targetC, targetR);
                
                while (current.x != targetPos.x || current.y != targetPos.y) {
                    current.modeTo(targetPos);
                    
                    Position moveRecord = new Position(current.x, current.y, current.time);
                    routeCountMap.put(moveRecord, routeCountMap.getOrDefault(moveRecord, 0) + 1);
                }
            }
        }
        
        int answer = 0;
        for (int count : routeCountMap.values()) {
            if (count > 1) {
                answer++;
            }
        }
        
        return answer;
    }
}