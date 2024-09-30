import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static StringBuilder sb  = new StringBuilder();
    public static int n, dest;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        dest = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        recur("", 1);
        System.out.println(sb);
    }

    /*
        첫 시도에서, stack overflow 뜸.
        원인은 if(n * 2 <= sen.length()) 이 부분에서 sen 뒤에 스페이스바를 붙인 것을 까먹고, if(n<= sen.length()) 로 해두어서
            무한 루프가 발생했기 때문이었음
     */
    public static void recur(String sen, int current){
//        System.out.println("sen > " + sen);
        if(n * 2 <= sen.length()){
            sb.append(sen + "\n");
            return;
        }
        else{
            for (int i = current; i <= dest; i++) {
                recur(sen + i + " ", i);
            }
        }
    }
}
