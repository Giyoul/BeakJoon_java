import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        int flag = -1;

        while(true){
            flag = 1;
            for(int i = 0; i < N.length(); i++){
                if(N.charAt(i) != '4' && N.charAt(i) != '7'){
                    flag = -1;
                    break;
                }
            }
            if(flag == 1) break;
            N = Integer.toString(Integer.parseInt(N) - 1);
        }
        System.out.print(N);
    }
}
