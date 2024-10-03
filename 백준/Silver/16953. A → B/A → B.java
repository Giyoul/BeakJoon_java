import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long from = Long.parseLong(st.nextToken());
        long to = Long.parseLong(st.nextToken());

        BFS(from, to);
    }

    public static class node{
        long count;
        long num;

        public node(long count, long num) {
            this.count = count;
            this.num = num;
        }
    }

    public static void BFS(long from, long to) {
        Queue<node> q = new LinkedList<>();
        q.add(new node(1, from));

        // 3. 그렇게 되면 처음에 수가 같은 반례를 걸러내지 못해서 이 코드 추가
        if(from == to){
            System.out.println(1);
            return;
        }

        while (!q.isEmpty()) {
            node cur = q.poll();
            // 1. 이렇게 하면 일방적인 방식이긴 한데, 사이즈가 커졌을 때 답이 없어짐.
//            if (cur.num == to) {
//                System.out.println(cur.count);
//                return;
//            }
            long doubleNum = cur.num * 2;
            long plusOneNum = cur.num * 10 + 1;

            // 2. 그래서 이 방식으로 고침
            if (doubleNum == to || plusOneNum == to) {
                System.out.println(cur.count + 1);
                return;
            }
            if(doubleNum < to){
                q.add(new node(cur.count+1, doubleNum));
            }
            if (plusOneNum < to) {
                q.add(new node(cur.count+1, plusOneNum));
            }
        }
        System.out.println("-1");
    }
}
