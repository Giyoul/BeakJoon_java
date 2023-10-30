import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int max, min;

        StringTokenizer st = new StringTokenizer(br.readLine());
        max = Integer.parseInt(st.nextToken());
        min  = max;

        for(int i = 0; i < N-1; i++){
            int num = Integer.parseInt(st.nextToken());
            if(num >= max) max = num;
            if(num < min) min = num;
        }

        System.out.print(min*max);
    }
}
