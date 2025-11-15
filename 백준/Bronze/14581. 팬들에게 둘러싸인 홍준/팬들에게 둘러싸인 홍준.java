import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(":fan::fan::fan:\n:fan::");
        sb.append(br.readLine()).append("::fan:\n:fan::fan::fan:");

        System.out.println(sb);
    }
}
