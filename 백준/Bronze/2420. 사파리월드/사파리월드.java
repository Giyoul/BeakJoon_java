import java.io.*;
import java.util.StringTokenizer;;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 단어 단위로 쪼갬

        // StringTokenizer에 nextToken()함수를 쓰면 readLine()을 통해 입력받은 값을 공백단위로 구분하여 순서대로 호출할 수 있다
        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        System.out.println(Math.abs(N-M));
    }
}