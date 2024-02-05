import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        // 120 -> 9 + 2 * 90 + 3 * 21

        int count = 1;
        int sum = 0;
        int length = 10;

        for(int i = 1; i <= N; i++){
            if(i == length){
                count++;
                length *= 10;
            }
            sum += count;
        }
        System.out.print(sum);
    }
}
