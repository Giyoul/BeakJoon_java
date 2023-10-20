import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] alphabet = new int[26];
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            char ch = br.readLine().charAt(0);
            alphabet[ch - 97]++;
        }

        for(int i = 0; i < 26; i++) {
			if(alphabet[i] >= 5) {
				sb.append((char) (i + 97));
			}
		}

        if(sb.length() == 0){
            System.out.print("PREDAJA");
        }
        else{
            System.out.print(sb.toString());
        }
    }
}