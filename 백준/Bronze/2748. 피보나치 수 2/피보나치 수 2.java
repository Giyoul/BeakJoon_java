import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        /*  피보나치로 푸니까 시간초과 나더라.
            System.out.print(fib(Integer.parseInt(br.readLine())));
        */
        long first = 0;
        long second = 1;

        if(n == 0){
            System.out.print(first);
        }
        else{
            for(int i = 0; i < n-1; i++){
                long tmp = second;
                second = first + second;
                first = tmp;
            }
            System.out.print(second);
        }
    }
}
