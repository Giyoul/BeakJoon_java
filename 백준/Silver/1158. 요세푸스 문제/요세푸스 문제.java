import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        LinkedList<Integer> list= new LinkedList<>();
        // insert all the numbers from 1 to N
        for(int i = 1; i <= N; i++){
            list.add(i);
        }

        sb.append("<");
        while(!list.isEmpty()){
            for(int i = 0; i < K; i++){
                // K의 자리에 있는 사람일 경우
                if(i == K-1){
                    // 리스트에 남은 마지막 한 사람일 경우
                    if(list.size() == 1){
                        sb.append(list.remove());
                    }
                    else{
                        sb.append(list.remove() + ", ");
                    }
                }
                else{
                    list.add(list.remove());
                }
            }
        }
        sb.append(">");
        System.out.print(sb);
    }
}
