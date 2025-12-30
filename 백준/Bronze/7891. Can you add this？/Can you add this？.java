import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            Long num1 = Long.parseLong(st.nextToken());
            Long num2 = Long.parseLong(st.nextToken());

            sb.append(num1 + num2).append("\n");
        }

        System.out.println(sb);
    }
}
