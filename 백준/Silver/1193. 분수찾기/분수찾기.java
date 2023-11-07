import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int X = Integer.parseInt(br.readLine());
        int n = 0; // total sum
        int count = 0; // how much you count
        while(n < X){
            n += ++count;
        }

        int need = X - (n - count);
        int parent = count - need + 1;
        int child = need;

        if(count % 2 == 0){
            System.out.print(child + "/" + parent);
        }
        else{
            System.out.print(parent + "/" + child);
        }
    }
}