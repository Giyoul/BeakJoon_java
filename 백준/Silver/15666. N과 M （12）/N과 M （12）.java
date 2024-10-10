import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<Integer> treeSet = new TreeSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            treeSet.add(Integer.parseInt(st.nextToken()));
        }

        List<Integer> list = new ArrayList<>(treeSet);
        int[] combination = new int[m];

        makeSequence(list, "", 0, 0, m, sb);
        System.out.print(sb);
    }

    private static void makeSequence(List<Integer> list, String sen, int index, int start, int m, StringBuilder sb) {
        if (index == m) {
            sb.append(sen).append("\n");
            return;
        }

        for (int i = start; i < list.size(); i++) {
            makeSequence(list, sen + (list.get(i) + " "), index + 1, i, m, sb);
        }
    }
}
