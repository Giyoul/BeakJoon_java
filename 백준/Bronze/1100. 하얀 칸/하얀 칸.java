import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int whiteCount = 0;
        for(int i = 0; i < 8; i++){
            String str = br.readLine();
            for(int j = 0; j < 8; j++){
                if((i + j) % 2 == 0){
                    if(str.charAt(j) == 'F'){
                        whiteCount++;
                    }
                }
            }
        }
        System.out.print(whiteCount);
    }
}