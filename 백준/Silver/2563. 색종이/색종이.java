import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        boolean[][] space = new boolean[100][100];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());   
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for(int j = 0; j < 10; j++){
                for(int k = 0; k < 10; k++){
                    if(!space[y+j][x+k]){
                        space[y+j][x+k] = true;
                        count++;
                    }
                }
            }
        }
        System.out.print(count);
    }
}