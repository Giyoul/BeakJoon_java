import java.util.Scanner;
// BigInteger는 math 매소드 안에 들어가 있다.
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        // BigInteger는 어떤 큰 수도 표현할 수 있다.
        BigInteger num1 = in.nextBigInteger();
        BigInteger num2 = in.nextBigInteger();

        /*  BigInteger의 사칙연산
         *  A.add(B)        ->  A + B
         *  A.subtract(B)   ->  A - B
         *  A.multiply(B)   ->  A * B
         *  A.divine(B)     ->  A / B
         *  A.mod(B)        ->  A % B
         */
        System.out.println(num1.add(num2));
        System.out.println(num1.subtract(num2));
        System.out.println(num1.multiply(num2));
    }
}
