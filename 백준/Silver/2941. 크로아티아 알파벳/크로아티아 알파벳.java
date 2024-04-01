import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sample = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        String st = br.readLine();
        int total = st.length();
        for(int i=0; i<8; i++){
            while(st.indexOf(sample[i]) != -1){
                st = st.replaceFirst(sample[i], "?");
                total-=(sample[i].length()-1);
            }
        }
        System.out.print(total);
    }

}

