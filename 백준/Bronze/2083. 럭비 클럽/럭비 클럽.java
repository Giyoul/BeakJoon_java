import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            if(name.equals("#")) break;

            if (Integer.parseInt(st.nextToken()) > 17 || Integer.parseInt(st.nextToken()) > 79) {
                sb.append(name).append(" ").append("Senior\n");
            } else {
                sb.append(name).append(" ").append("Junior\n");
            }
        }

        System.out.println(sb);
    }
}