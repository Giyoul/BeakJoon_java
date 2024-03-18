/*
 * queue를 사용하면 쉽게 풀 수 있는 문제이다.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            q.add(i+1);
        }

        while(true){
            sb.append(q.poll() + " ");
            if(q.isEmpty()) break;
            q.add(q.poll());
        }

        System.out.print(sb);
    }

}

