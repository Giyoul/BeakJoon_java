import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Double D = Double.parseDouble(st.nextToken());
        Double H = Double.parseDouble(st.nextToken());
        Double W = Double.parseDouble(st.nextToken());

        // 가로 Hx, 세로 Wx라 할때, x = D / (H^2 + W^2)^(1/2) 이다.
        Double x = D / Math.sqrt(Math.pow(H, 2) + Math.pow(W, 2));
        System.out.print((int)(H*x) + " " + (int)(W*x));
    }
}
