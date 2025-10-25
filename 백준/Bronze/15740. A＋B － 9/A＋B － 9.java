import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BigInteger n1 = new BigInteger(st.nextToken());
        BigInteger n2 = new BigInteger(st.nextToken());

        System.out.println(n1.add(n2));
    }
}