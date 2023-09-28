import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int[] standard = {1, 1, 2, 2, 2, 8};

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < 6; i++){
            System.out.print(standard[i]-Integer.parseInt(st.nextToken()) + " ");
        }
    }
}
