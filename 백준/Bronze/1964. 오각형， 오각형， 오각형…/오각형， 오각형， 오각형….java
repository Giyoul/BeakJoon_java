import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        // f(1) = 5, f(2) = 12, f(n) = f(n-1) + (3*n+1);
        long sum = 5;
        int add = 7;

        for(int i = 1; i < n; i++){
            sum += add;
            add += 3;
        }
        System.out.print(sum % 45678);
    }
}
