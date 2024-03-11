/*
 * 나열해보면 아래를 만족한다
 * answer[n] = answer[n-1] + answer[n-2];
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));

        int n = Integer.parseInt(br.readLine());
        long [] answer = new long[n+1];
        answer[0] = 0;
        answer[1] = 1;

        for(int i = 2; i <= n; i++){
            answer[i] = answer[i-1] + answer[i-2];
        }
        System.out.print(answer[n]);
    }
}