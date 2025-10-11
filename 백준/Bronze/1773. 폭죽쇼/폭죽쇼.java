import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        Set<Integer> inputCycles = new HashSet<>();
        for (int i = 0; i < n; i++) inputCycles.add(Integer.parseInt(br.readLine()));

        List<Integer> sortedCycles = new ArrayList<>(inputCycles);
        Collections.sort(sortedCycles);

        Set<Integer> finalCycles = new HashSet<>();

        for(int currentCycle : sortedCycles){
            boolean check = false;

            for (int smallerCycle : finalCycles) {
                if (currentCycle % smallerCycle == 0) {
                    check = true;
                    break;
                }
            }

            if (!check) finalCycles.add(currentCycle);
        }

        boolean[] exploded = new boolean[c + 1];
        int count = 0;

        for (int cycle : finalCycles) {
            for (int day = cycle; day <= c; day += cycle) {
                if (!exploded[day]) {
                    exploded[day] = true;
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}