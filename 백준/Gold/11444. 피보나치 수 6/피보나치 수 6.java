import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /*
           1 1
           1 0
           행렬의 우측에 곱하는 것은 피보나치와 같음.
     */
    public static long div = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        // (f(n+1) f(n)  ) = (1 1)n
        // (f(n)   f(n-1))   (1 0)
//        따라서 ans[0][1]이 f(n)이라서 결과는 이거로 출력

        long[][] ans = recur(n);
        System.out.println(ans[0][1]);


//        첫 시도는 아래 같이 했으나 시간초과 바로 뜸.
//        long cur = 0;
//        long pre = 0;
//
//        if(n == 1){
//            cur = 1;
//        } else if(n != 0){
//            cur = 1;
//            for(int i = 2; i <= n; i++){
//                long tmp = cur;
//                cur = (pre + cur) % 1000000007;
//                pre = tmp;
//            }
//        }
//
//        System.out.println(cur);
    }
    public static long[][] base = new long[][]{{1, 1}, {1, 0}};
    public static long[][] recur(long N){
        long[][] temp = null;
        if(N == 1) return base;
        if(N % 2 == 0){ // 짝수일때.
            temp = recur(N / 2);
            return multiply(temp, temp);
        } else {    // 홀 수 일때.
            temp = recur((N - 1) / 2);
            return multiply(base, multiply(temp, temp));
        }
    }

    // 행렬 곱을 리턴한다.
    public static long[][] multiply(long[][] a, long[][] b){
        long[][] answer = new long[2][2];

        // 반복문보다는 직접 제곱하는 과정
        answer[0][0] = (a[0][0]*b[0][0] + a[0][1]*b[1][0])% div;
        answer[0][1] = (a[0][0]*b[0][1] + a[0][1]*b[1][1])% div;
        answer[1][0] = (a[1][0]*b[0][0] + a[1][1]*b[1][0])% div;
        answer[1][1] = (a[1][0]*b[0][1] + a[1][1]*b[1][1])% div;

        return answer;
    }
}
