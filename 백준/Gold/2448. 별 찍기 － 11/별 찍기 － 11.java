import java.io.*;
public class Main {
    static String[] star;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        star = new String[N];

        star[0] = "  *  ";
        star[1] = " * * ";
        star[2] = "*****";

        for (int i = 1; 3 * Math.pow(2, i) <= N; i++)
            writeStar(i);

        //별 찍기 결과 BufferedWriter 저장
        for (int i = 0; i < N; i++)
            bw.write(star[i] + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void writeStar(int i) {
        int bottom = (int) (3 * Math.pow(2, i));    //삼각형의 총 행수
        int middle = bottom / 2;    //삼각형의 중앙값

        for (int j = middle; j < bottom; j++) // 삼각형 하단 절반 그리기
            star[j] = star[j - middle] + " " + star[j - middle];
        String blank = " ".repeat(middle); // 반복문 대신

        for (int j = 0; j < middle; j++) // 삼각형 상단 절반. 가운데 삼각형 배치
            star[j] = blank + star[j] + blank;
    }
}