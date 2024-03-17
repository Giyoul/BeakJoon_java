/*
 * priority queue가 있다.
 * 이거 크기 순으로 자동정렬해주는 queue이다.
 * 원래는 가장 작은 수가 먼저 나오게 되어있다.
 * 따라서 Comparator.reverseOrder()를 사용해서 큰 수가 먼저 나오게 바꿔줘야 한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        int me = Integer.parseInt(br.readLine());
        for(int i = 1; i < n; i++){
            pq.add(Integer.parseInt(br.readLine()));
        }

        int count = 0;
        if(n != 1){
            while(true){
                int temp = pq.poll();
                if(temp < me) break;
                else{
                    count++;
                    me++;
                    pq.add(--temp);
                }
            }
        }

        System.out.print(count);
    }
}