import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String response = br.readLine();
        String require = br.readLine();

        String ans = require.length() > response.length() ? "no" : "go";
        System.out.println(ans);
    }
}