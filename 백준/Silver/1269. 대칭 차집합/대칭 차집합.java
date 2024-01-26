import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        // create hashset
        HashSet<Integer> setA = new HashSet<>();
        HashSet<Integer> setB = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        // add a's numbers in hashset a
        for(int i = 0; i < a; i++){
            setA.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        // check b's numbers are in the hashset a
        for(int i = 0; i < b; i++){
            // target number
            int numberB = Integer.parseInt(st.nextToken());

            // if it contains
            if(setA.contains(numberB)){
                // remove target number in hashset a
                setA.remove(numberB);
            }
            // if not
            else{
                // add target number in hashset a
                setA.add(numberB);
            }
        }
        System.out.println(setA.size());

    }                           
}
