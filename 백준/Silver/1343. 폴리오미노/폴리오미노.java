/*
 * replace로 XXXX를 먼저 AAAA로 바꿔주고, XX를 BB로 바꿔준다.
 * 다음으로 X가 있는지 찾아보고 없으면 모든 X가 대체된것이고 있으면 다 replace하지 못한 것이다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));

        String st = br.readLine();
        st = st.replace("XXXX", "AAAA");
        st = st.replace("XX", "BB");

        if(st.indexOf('X') != -1){
            System.out.print(-1);
        } else { 
            System.out.print(st);
        }
    }
}