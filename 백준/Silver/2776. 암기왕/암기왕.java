import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testcase = Integer.parseInt(br.readLine());

        for(int j = 0; j < testcase; j++){
            int note1 = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
    
            HashSet<Integer> set = new HashSet<>();
            for(int i = 0; i < note1; i++){
                set.add(Integer.parseInt(st.nextToken()));
            }
    
            int note2 = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < note2; i++){
                if(set.contains(Integer.parseInt(st.nextToken()))){
                    sb.append("1").append("\n");
                }else{
                    sb.append("0").append("\n");
                }
            }
        }

        System.out.print(sb);
    }
}
