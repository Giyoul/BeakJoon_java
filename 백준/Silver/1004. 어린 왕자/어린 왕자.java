import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // testcase
        int T = Integer.parseInt(br.readLine());

        // minimum count of planet
        for(int j = 0; j < T; j++){
            // starting point and end destination
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            // number of planet
            int n = Integer.parseInt(br.readLine());

            int minCount = 0;
            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                double tempX = Double.parseDouble(st.nextToken());
                double tempY = Double.parseDouble(st.nextToken());
                double tempRadius = Double.parseDouble(st.nextToken());
                int flag = 0;   // if flag is 0, starting point is not in radius | if 1, starting point is in radius
                if(Math.sqrt(Math.pow((tempX - x1), 2) + Math.pow((tempY - y1), 2)) < tempRadius){   // compare starting point to planet
                    minCount++;
                    flag = 1;
                }
                if(Math.sqrt(Math.pow((tempX - x2), 2) + Math.pow((tempY - y2), 2)) < tempRadius){   // compare destination to planet
                    minCount++;
                    if(flag == 1){  // if starting point and destination both is in the circle
                        minCount-=2;
                    }
                }
            }
            System.out.println(minCount);
        }
        
    }
}
