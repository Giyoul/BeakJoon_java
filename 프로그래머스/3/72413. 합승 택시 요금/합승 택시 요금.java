class Solution {
    private static final int INF = 20000001;
    int[][] dist;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        initDist(n, fares);
        
        floydWarshall(n);
        
        return findMin(n, s, a, b);
    }
    
    private void initDist(final int n, final int[][] fares) {
        dist = new int[n+1][n+1];
        for(int from = 1; from <= n; from++) {
            for(int to = 1; to <= n; to++) {
                if(from == to) {
                    dist[from][to] = 0;
                } else {
                    dist[from][to] = INF;
                }
            }
        }
        
        for(int[] fare : fares) {
            int from = fare[0];
            int to = fare[1];
            int cost = fare[2];
            
            dist[from][to] = cost;
            dist[to][from] = cost;
        }
    }
    
    private void floydWarshall(int n){
        for(int stopover = 1; stopover <= n; stopover++) {
            for(int from = 1; from <= n; from++) {
                for(int to = 1; to <= n; to++) {
                    int stopoverCost = dist[from][stopover] + dist[stopover][to];
                    if(dist[from][to] > stopoverCost) {
                        dist[from][to] = stopoverCost;
                    }
                }
            }
        }
    }
    
    private int findMin(int n, int start, int destA, int destB) {
        int min = INF;
        for(int i = 1; i <= n; i++) {
            if(min > dist[start][i] + dist[i][destA] + dist[i][destB]){
                min = dist[start][i] + dist[i][destA] + dist[i][destB];
            }
        }
        
        return min;
    }
}