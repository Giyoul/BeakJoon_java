import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        if (Integer.parseInt(st.nextToken()) * 100 < Integer.parseInt(st.nextToken())) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
    }
}