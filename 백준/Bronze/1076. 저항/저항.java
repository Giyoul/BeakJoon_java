import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> regist = Arrays.asList("black", "brown","red", "orange", "yellow", "green", "blue", "violet", "grey", "white");
        long ans = 0;
        
        ans += 10 * (regist.indexOf(br.readLine()));
        ans += 1 * (regist.indexOf(br.readLine()));
        ans *= Math.pow(10, regist.indexOf(br.readLine()));

        System.out.print(ans);
    }
}
