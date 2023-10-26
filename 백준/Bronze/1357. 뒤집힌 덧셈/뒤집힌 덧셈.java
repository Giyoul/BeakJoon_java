import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        System.out.print(Rev(Rev(X) + Rev(Y)));
    }

    static int Rev(int x){
        int result = 0;
        while(x > 0){
            result = result * 10 + x % 10;
            x/=10;
        }
        return result;
    }
}
