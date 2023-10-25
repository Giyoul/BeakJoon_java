import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int currentBeat = m;
        int spendTime = 0;
        int toTargetTime = 0;

        while(N != toTargetTime){
            if(M-m < T){
                spendTime = -1;
                break;
            }
            if(currentBeat + T > M){
                currentBeat -= R;
            }
            else{
                toTargetTime++;
                currentBeat += T;
            }
            if(currentBeat < m) currentBeat = m;
            spendTime++;
        }

        System.out.print(spendTime);
    }
}
