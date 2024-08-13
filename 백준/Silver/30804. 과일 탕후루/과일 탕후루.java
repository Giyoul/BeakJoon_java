import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int maxCount = 0;
        int lastCount = 0;
        int currentCount = 1;
        int lastToken = 0;
        int currentToken= Integer.parseInt(st.nextToken());
        int continuous = 1;

        while (st.hasMoreTokens()) {
            int token = Integer.parseInt(st.nextToken());
            if (token == currentToken) {
                currentCount++;
                continuous++;
            } else if (token == lastToken) {
                lastCount++;
                continuous = 1;
                int tmp = currentCount;
                currentCount = lastCount;
                lastCount = tmp;
                lastToken = currentToken;
                currentToken = token;
            } else {
                if (maxCount < lastCount + currentCount) {
                    maxCount = lastCount + currentCount;
                }
                lastToken = currentToken;
                lastCount = continuous;
                continuous = 1;
                currentToken = token;
                currentCount = 1;
            }
        }
        if (maxCount < lastCount + currentCount) {
            maxCount = lastCount + currentCount;
        }

        System.out.println(maxCount);
    }
}
