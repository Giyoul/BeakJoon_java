import java.util.Queue;
import java.util.ArrayDeque;

class Solution {
    private class ScaleInfo {
        public int time;
        public int size;
        
        public ScaleInfo(int time, int size) {
            this.time = time;
            this.size = size;
        }
    }
    
    public int solution(int[] players, int m, int k) {
        Queue<ScaleInfo> scaledTime = new ArrayDeque<>();
        
        int scaleCount = 0;
        int currentMaxPlayer = m;
        for(int time = 0; time < players.length; time++) {
            if(!scaledTime.isEmpty() && time - scaledTime.peek().time >= k){
                currentMaxPlayer -= scaledTime.peek().size * m;
                scaledTime.poll();
            }
            int player = players[time];
            
            if(isNeedScale(player, currentMaxPlayer)) {
                int scaleUpSize = countScaleUpSize(player, m, currentMaxPlayer);
                scaleCount += scaleUpSize;
                currentMaxPlayer += scaleUpSize * m;
                scaledTime.offer(new ScaleInfo(time, scaleUpSize));
            }
        }
        
        return scaleCount;
    }
    
    private boolean isNeedScale(int player, int currentMaxPlayer) {
        if(currentMaxPlayer <= player) return true;
        return false;
    }
    
    private int countScaleUpSize(int player, int maxPlayer, int currentMaxPlayer) {
        int neededPlayer = player - currentMaxPlayer;
        
        if(neededPlayer == 0) return 1;
        
        return neededPlayer / maxPlayer + 1;
    }
}