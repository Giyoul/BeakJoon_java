import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            Deque<Integer> integerDeque = new LinkedList<>();
            sb = new StringBuilder();
            String s = br.readLine();
            boolean reverse = false;
            boolean flag = true;
            int t = Integer.parseInt(br.readLine());
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input, "[],");

            for(int j = 0; j < t; j++) {
                integerDeque.add(Integer.parseInt(st.nextToken().trim()));
            }

            int j = s.length();
            for(int k = 0; k < j; k++) {
                if(s.charAt(k) == 'R') {
                    reverse = !reverse;
                }
                else if(s.charAt(k) == 'D') {
                    if (!integerDeque.isEmpty()) {
                        if (reverse) {
                            integerDeque.removeLast();
                        } else {
                            integerDeque.removeFirst();
                        }
                    } else {
                        sb.delete(0, sb.length());
                        sb.append("error");
                        flag = false;
                        break;
                    }
                }
            }

            if(flag) {
                int size = integerDeque.size() - 1;
                sb.append("[");
                if (reverse) {
                    for(int k = 0; k < size; k++) {
                        sb.append(integerDeque.removeLast()).append(",");
                    }
                } else {
                    for(int k = 0; k < size; k++) {
                        sb.append(integerDeque.removeFirst()).append(",");
                    }

                }
                if (!integerDeque.isEmpty()) {
                    sb.append(integerDeque.getFirst());
                }
                sb.append("]");
            }

            System.out.println(sb);
        }
    }
}
