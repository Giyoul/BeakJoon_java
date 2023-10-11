import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int L = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int people = L * P;

        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            int n = Integer.parseInt(st.nextToken());
            System.out.print((n-people) + " ");
        }
    }
}
