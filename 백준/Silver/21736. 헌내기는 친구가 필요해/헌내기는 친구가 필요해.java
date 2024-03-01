import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

class Main {
    static char[][] map;
    static boolean[][] visit;
    static int posx[] = {-1, 1, 0, 0};
    static int posy[] = {0, 0, -1, 1};
    static int current_x, current_y;   // 현위치
    static int sizeN, sizeM;

    public static void main(String[] args) throws IOException {
        /*
         * N, M값을 받는다.
         * 한줄씩 받아서 charAt(i)로 분리해서 Graph에 저장한다.
         * visit을 만들어서, X일 경우에 visit을 true로 변경해준다.
         * I를 만났을 때, current_pos를 저장해준다.
         * 
         * Queue<int[]> q = new Linkedist<>();로 DFS를 구현해주고,
         * q.add(new int[] {x, y}) 와 q.poll() 해준다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // N == y, M == x
        sizeN = Integer.parseInt(st.nextToken());
        sizeM = Integer.parseInt(st.nextToken());
        map = new char[sizeN][sizeM];
        visit = new boolean[sizeN][sizeM];

        for(int i = 0; i < sizeN; i++){
            String str = br.readLine();
            for(int j = 0; j < sizeM; j++){
                char ch = str.charAt(j);
                map[i][j] = ch;
                if(ch == 'X'){  // 벽인 경우, 이미 방문한거로 친다.
                    visit[i][j] = true;
                }
                else if(ch == 'I'){ // 도연이가 있는 위치인 경우, 현재 위치를 저장해준다.
                    current_x = j;
                    current_y = i;
                }
            }
        }

        // 깊이 우선 탐색
        int metPeople = DFS(current_x, current_y);

        if(metPeople == 0){ // 아무도 못만났을 경우 TT 출력
            System.out.println("TT");
        }
        else{
            System.out.println(metPeople);
        }
    }

    public static int DFS(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x, y});
        visit[y][x] = true;

        int movex, movey;
        int count = 0;
        int[] location;

        while(!q.isEmpty()){    // queue가 비어있지 않은 경우에
            location = q.poll();
            if(map[location[1]][location[0]] == 'P') count++;
            for(int i = 0; i < 4; i++){ // 사방향 방문
                movex = location[0] + posx[i];
                movey = location[1] + posy[i];
                if(movex >= 0 && movey < sizeN && movey >= 0 && movex < sizeM){ // 학교의 범위를 벗어나지 않고
                    if(!visit[movey][movex]){ // 방문 안한곳이면
                        visit[movey][movex] = true;
                        q.add(new int[] {movex, movey});
                    }
                }
            }
        }

        return count;
    }
}