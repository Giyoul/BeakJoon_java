import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        LinkedList<Integer> deque = new LinkedList<>();
        for(int i = 1; i <= N; i++){
            deque.add(i);
        }

        int count = 0;
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < M; i++){
            int num = Integer.parseInt(st.nextToken());
            if(deque.size()/2 >= deque.indexOf(num)){
                while(deque.peekFirst() != num){
                    deque.add(deque.pollFirst());
                    count++;
                }
            }else{
                while(deque.peekFirst() != num){
                    deque.push(deque.pollLast());
                    count++;
                }
            }
            deque.pollFirst();
            
        }

        System.out.print(count);
    }
}
