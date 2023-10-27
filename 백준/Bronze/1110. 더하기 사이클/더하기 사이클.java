import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int target = num;
        int count = 0;

        while(true){
            count++;
            num = NewNum(num);
            if(num == target) break;
        }

        System.out.print(count);
    }
    private static int NewNum(int n){
        int a = n % 10;
        n /= 10;
        int sum = n + a;
        return a * 10 + sum % 10;
    }
}
