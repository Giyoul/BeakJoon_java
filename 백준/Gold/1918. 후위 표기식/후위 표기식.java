import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String formula = br.readLine();
        int length = formula.length();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < length; i++) {
            char ch = formula.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                sb.append(ch);  // 피연산자면 바로 출력
            } else if (ch == '(') {
                stack.push(ch);  // 여는 괄호는 스택에 쌓음
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());  // 여는 괄호 전까지 연산자를 모두 pop
                }
                stack.pop();  // 여는 괄호 제거
            } else {  // 연산자 처리
                while (!stack.isEmpty() && priority(stack.peek()) >= priority(ch)) {
                    sb.append(stack.pop());  // 우선순위가 같거나 높으면 스택에서 pop
                }
                stack.push(ch);  // 현재 연산자를 스택에 push
            }
        }

        // 스택에 남아 있는 연산자들을 모두 pop
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }

    public static int priority(char ch) {
        if (ch == '+' || ch == '-') {
            return 1;  // +, -는 우선순위 1
        } else if (ch == '*' || ch == '/') {
            return 2;  // *, /는 우선순위 2
        } else {
            return 0;  // 괄호나 기타 다른 경우
        }
    }
}
