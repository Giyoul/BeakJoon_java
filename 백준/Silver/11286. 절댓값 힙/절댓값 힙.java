import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Long> pq =  new PriorityQueue<>(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                if(Math.abs(o1) > Math.abs(o2)) {
                    return (int)(Math.abs(o1) - Math.abs(o2));
                }else if (Math.abs(o1) == Math.abs(o2)) {
                    return (int)(o1-o2);
                } else {
                    return -1;
                }
            }
        });
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine());
            if (tmp == 0) {
                if (pq.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(pq.poll()).append("\n");
                }
            } else {
                pq.add(Long.valueOf(tmp));
            }
        }

        System.out.println(sb);

    }
}
