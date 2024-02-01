import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String A = st.nextToken();
        String B = st.nextToken();
        // 다른 문자의 최대 개수를 저장
        int maxNumberOfDifferentLetters = B.length();

        // repeat as many letters as B
        for(int i = 0; i <= B.length() - A.length(); i++){
            int difNumCount = 0;
            for(int j = 0; j < A.length(); j++){
                if(A.charAt(j) != B.charAt(i+j)){
                    difNumCount++;
                }
            }
            maxNumberOfDifferentLetters = Math.min(maxNumberOfDifferentLetters, difNumCount);
        }
        System.out.print(maxNumberOfDifferentLetters);

    }
}