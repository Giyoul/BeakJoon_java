import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        // use bit operator to solve the problem
        long answer = 0L;
        int digits = 0;

        // 개수를 세보면, 3의 제곱수의 n번째 큰 수는 2의 배수이다
        while(N > 0){
            // N의 첫 자리가 1이면 ex) 001001
            if((N & 1) == 1){
                answer += powerThree(digits);
            }
            digits++;
            // 비트를 오른쪽으로 한자리씩 옮겨줌
            N = N >> 1;
        }
        System.out.print(answer);
    }
    
    // 3의 제곱
    private static long powerThree(long n){
        long ans = 1L;
        for(Long i = 0L; i < n; i++){
            ans *= 3;
        }
        return ans;
    }
}
