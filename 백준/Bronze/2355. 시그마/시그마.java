import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long from = Long.parseLong(st.nextToken());
        long to = Long.parseLong(st.nextToken());
        if (from > to) {
            long temp = from;
            from = to;
            to = temp;
        }
        long result;

        boolean even = (to - from) % 2 != 0;
        if (even) {
            result = (from + to) * ((to - from + 1) / 2);
        } else {
            result = (from + to) * ((to - from + 1) / 2) + (from + to) / 2;
        }
        System.out.println(result);
    }
}