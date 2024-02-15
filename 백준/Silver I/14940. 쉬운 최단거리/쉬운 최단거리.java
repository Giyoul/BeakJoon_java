import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static boolean visited[][];
    static int map[][], result[][], startx, starty, n, m;
    static int[] dx = {1, 0, -1, 0}; // 오른쪽, 위, 왼쪽, 아래
    static int[] dy = {0, 1, 0, -1}; // 오른쪽, 위, 왼쪽, 아래
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];  // 지도
        result = new int[n][m]; // 결과
        visited = new boolean[n][m];    // 방문여부

        for(int i = 0; i < n; i++){
            Arrays.fill(result[i], -1);    // 일단 모두 갈 수 없다고 가정하고 -1로 초기화
        }

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                int k = Integer.parseInt(st.nextToken());
                map[i][j] = k;
                if(k==2){
                    result[i][j] = 0;
                    startx=j;
                    starty=i;
                }else if(k==0){
                    visited[i][j] = true;   // 갈 수 없는 땅은 이미 간 것으로 간주해서 나중에 queue에 추가되지 못하도록 한다.
                    result[i][j] = 0;
                }
            }
        }

        BFS(startx, starty);

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void BFS(int x, int y){
        Queue<int[]>queue = new LinkedList<>();
        queue.add(new int[] {y,x});
        visited[y][x] = true;

        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            for(int i = 0; i < 4; i++){ // 사방향 탐색
                int posy = temp[0] + dy[i];
                int posx = temp[1] + dx[i];
                if(posy >= 0 && posy < n && posx >= 0 && posx < m){ // map의 경계를 벗어나지 않았는지 체크
                    if(!visited[posy][posx] && map[posy][posx] == 1){   // 방문하지 않은 땅은
                        result[posy][posx] = result[temp[0]][temp[1]] + 1;  // 오기 전 땅 + 1의 거리를 넣어주고
                        visited[posy][posx] = true; // 왔다고 표시해주고
                        queue.add(new int[] {posy, posx});  // 큐에 추가해준다.
                    }
                }
            }
        }
    }
}
