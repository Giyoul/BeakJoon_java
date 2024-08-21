import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st1.nextToken());
        int P = Integer.parseInt(st1.nextToken());

        int count = 0;
        for (int n = 0; n < 6; n++) {
            int token = Integer.parseInt(st.nextToken());
            count += token / T;
            if (token % T != 0) count++;
        }

        System.out.println(count);
        System.out.println(N/P + " " + N%P);
    }
}
