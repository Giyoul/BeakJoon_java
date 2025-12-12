import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int y = Integer.parseInt(br.readLine());
        int x = Integer.parseInt(br.readLine());

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
