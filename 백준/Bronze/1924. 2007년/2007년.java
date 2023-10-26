import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final String[] dayName = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
        final int[] monthDay = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());

        int dayCount = 0;
        for(int i = 0; i < month-1; i++){
            dayCount += monthDay[i];
        }
        dayCount += day - 1;
        dayCount = dayCount % 7;

        System.out.print(dayName[dayCount]);
    }
}
