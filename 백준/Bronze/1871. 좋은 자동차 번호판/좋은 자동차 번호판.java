import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), "-");
            String front = st.nextToken();
            int frontValue = ((front.charAt(0) - 'A') * 676) + ((front.charAt(1) - 'A') * 26) + (front.charAt(2) - 'A');
            int back = Integer.parseInt(st.nextToken());
            if(Math.abs(frontValue - back) <= 100) sb.append("nice\n");
            else sb.append("not nice\n");
        }
        System.out.println(sb);
    }
}