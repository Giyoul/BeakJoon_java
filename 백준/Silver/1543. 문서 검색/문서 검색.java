/*
 * find 함수를 사용해서 찾은 부분의 인덱스 뒤에부터 찾으면 된다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));

        String target = br.readLine();
        String finding = br.readLine();
        int count = 0;
        int index = 0;
        int findingSize = finding.length();

        while(target.indexOf(finding, index) != -1){    // 찾지 못할때까지
            count++;
            index = target.indexOf(finding, index) + findingSize;
        }
        System.out.println(count);
    }
}