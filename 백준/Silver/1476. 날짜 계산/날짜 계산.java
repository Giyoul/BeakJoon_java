import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int currentE = 0;
        int currentS = 0;
        int currentM = 0;
        int count = 0;

        while(true){
            currentE++;
            currentS++;
            currentM++;
            count++;

            if(currentE > 15) currentE = 1;
            if(currentS > 28) currentS = 1;
            if(currentM > 19) currentM = 1;

            if(currentE != E) continue;
            if(currentS != S) continue;
            if(currentM != M) continue;

            break;
        }

        System.out.print(count);
    }
}