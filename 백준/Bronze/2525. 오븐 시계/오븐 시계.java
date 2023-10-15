import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int addM = Integer.parseInt(br.readLine());

        H = (H + (M + addM) / 60) % 24;
        M = (M + addM) % 60;

        System.out.print(H + " " + M);
    }
}
