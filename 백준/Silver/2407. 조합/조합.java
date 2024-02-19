import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        BigInteger n = new BigInteger(st.nextToken());
        BigInteger m = new BigInteger(st.nextToken());
        
        BigInteger nFac = new BigInteger("1");
        for(int i = 1; i <= n.intValue(); i++){
            nFac = nFac.multiply(BigInteger.valueOf(i));
        }

        BigInteger mFac = new BigInteger("1");
        for(int i = 1; i <= m.intValue(); i++){
            mFac = mFac.multiply(BigInteger.valueOf(i));
        }

        BigInteger nMinusmFac = new BigInteger("1");
        for(int i = 1; i <= n.intValue() - m.intValue(); i++){
            nMinusmFac = nMinusmFac.multiply(BigInteger.valueOf(i));
        }

        // nCm n! / m! * (n-m)!
        System.out.println(nFac.divide((mFac.multiply(nMinusmFac))));
    }
}