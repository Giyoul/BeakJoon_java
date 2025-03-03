import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int[] p;
    static int N;
    static int M;
    static char[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        p = new int[N * M];
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
                p[i * M + j] = i * M + j;
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                int ni = i;
                int nj = j;
                if(map[i][j] == 'U') ni--;
                else if(map[i][j] == 'D') ni++;
                else if(map[i][j] == 'L') nj--;
                else nj++;
                union(i*M+j, ni*M+nj);
            }
        }

        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                set.add(find_parent(i * M + j));
            }
        }
        System.out.println(set.size());
    }

    static void union(int a, int b) {
        int A = find_parent(a);
        int B = find_parent(b);
        if(A < B) p[B] = A;
        else p[A] = B;
    }

    static int find_parent(int a) {
        if(p[a] == a) return a;
        else return p[a] = find_parent(p[a]);
    }
}