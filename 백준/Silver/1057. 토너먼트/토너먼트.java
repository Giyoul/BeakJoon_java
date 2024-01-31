import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int total = Integer.parseInt(st.nextToken());
        int Jimin = Integer.parseInt(st.nextToken());
        int Hansoo = Integer.parseInt(st.nextToken());
        int count = 0;
        
        while(Jimin != Hansoo){
            Jimin = Jimin / 2 + Jimin % 2;
            Hansoo = Hansoo / 2 + Hansoo % 2;
            count++;
        }
        System.out.print(count);
    }
}
