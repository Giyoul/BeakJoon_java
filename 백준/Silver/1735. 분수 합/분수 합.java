/*
 * 유클리드 호제법을 이용해서 푸는 문제이다.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numeratorN1 = Integer.parseInt(st.nextToken()); // 분자
        int denominatorN1 = Integer.parseInt(st.nextToken());   // 분모

        st = new StringTokenizer(br.readLine());
        int numeratorN2 = Integer.parseInt(st.nextToken()); // 분자
        int denominatorN2 = Integer.parseInt(st.nextToken());   // 분모

        int sumNume = numeratorN1*denominatorN2 + numeratorN2*denominatorN1;    // 덧셈한 결과의 분자
        int sumDeno = denominatorN1*denominatorN2;  // 덧셈한 결과의 분모

        int EUCD;
        if(sumDeno > sumNume){
            EUCD = eucd(sumDeno, sumNume);
        } else {
            EUCD = eucd(sumNume, sumDeno);
        }
        
        System.out.print(sumNume/EUCD + " " + sumDeno/EUCD);
    }

    public static int eucd(int bn, int sn){    // 유클리드 호제법
        int r = bn % sn; // 큰숫자를 작은숫자로 나눈 나머지를 계산
        if (r == 0) {   // 나머지가 0이면 작은숫자가 최대공약수이므로 작은숫자 리턴
            return sn;
        } else {
            // 나머지가 0 이상이면 재귀형태로 호출
            // 이때 파라미터는 작은숫자와 나머지를 넣어줌
            return eucd(sn, r);
        }
    }
}

