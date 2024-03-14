/*
 * 브르투포스
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int count = 0;
        long sum = 0;
        long n = Long.parseLong(br.readLine());
        while(sum <= n){
            sum += ++count;
        }

        System.out.println(--count);
    }

}

