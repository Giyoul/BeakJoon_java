import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String S = br.readLine();

        Map<Integer, Long> dp = new HashMap<>();

        /*
            여기부터 주석이 전부 끝나기 전까지는 아래 56번째 줄 코드 한 줄을 이해하기 위한 설명임.
            이거 이해 못하면 뒤에는 그냥 이해 못하는거니 정독하셈.

            여기서부터 이해 못할 어리석은 김도현을 위해 설명해주자면 삼진법 쓴거임.
            T라는 문자열과 M이라는 문자열이 있다고 쳐보고 두개를 비교한다고 가정해보셈.
            그리고 지금 i번쨰 인덱스에서 얼마나 맞나 비교하고 있다고 쳐보셈
            LCS에서 v1은 '이전 칸' 즉, T의 i번째 인덱스랑 M을 i-1번째 글짜까지 써서 얼마나 손해 보고 있는지를 나타냄.
            v2는 '현재 칸' 즉, T랑 M을 둘 다 똑같이 i개씩 썼을때 LCS가 i에서 얼마나 모자란지임.
            -> 문제에서 딱 한 글자 차이난다고 했으니까 i = n일때 이 값이 -1 이어야 n-1 인거임
            v3는 '다음 칸' 즉, T는 i개 썼는데, M은 한 글자 더 고려했을때의 LCS 값임.
            여기까지 이해 못하면 아래를 이해할 수 없음.
         */

        /*
            이제 아래의 수식 한 줄을 이해하는게 필요함.
            예를 들어서 123이라는 숫자가 있다고 쳐보셈 (백이십삼임)
            이거가 (1 x 100) + (2 x 10) + (3 x 1)임.

            여기서 v1, v2, v3는 상태가 딱 세 가지임. (-2, -1, 0)
            그런데, 마이너스로 넘어가면 나중에 답 구하기 어려우니까 각각에 임의로 2를 더해서 양수로 만들어줌.(0, 1, 2)
            왜 2냐? 내 맘임. 숫자 보기 편해서 그럼. 안더해도 되는데, index값으로 만들어야 해서 이렇게 한거임.
            123에서는 각 숫자에서 10의 n승을 곱했음.
            근데 여기서는 3의 n승을 곱해줘서 모든 경우의 수를 파악하는 것임.

            v1에는 3^2 = 9를 곱하고
            v2에는 3^1 = 3을 곱하고
            v3에는 3^0 = 1을 곱할꺼임.
            이러면 v1, v2, v3 세 가지 숫자가 만들어낼 수 있는 0~26까지의 숫자 조합을 hash코드의 key로 만드는 트릭이 되는거임.

            ex) v1 = 2, v2 = 2, v3 = 2이면, (2 x 9) + (2 x 3) + (2 x 1) = 18 + 6 + 2 = 26
            ex2) v1 = 2, v2 = 2, v3 = 1이면, (2 x 9) + (2 x 3) + (1 x 1) = 18 + 6 + 1 = 25

            정리하자면, 그냥 접근하면 시간초과 나니까, hashmap 쓰기 위한 고유한 key값을 만들기 위한 트릭인것임.
            인코딩을 * 3^n으로 했으니까, 디코딩은 /랑 %3 쓰면 됨.
         */

        // 따라서 아래는 i = 0, v1 = 0, v2 = 0, v3 = -1일때의 초기 hashmap key값임.
        // v3 = -1인 이유: 빈 문자열 T에서 LCS("", S[0..0]) = 0이므로 val_plus1 = 1 + v3 = 0 → v3 = -1
        int init = (2 * 9) + (2 * 3) + 1; // 25
        dp.put(init, 1L);

        /*
            현재 상태가 빈 String이라고 생각하셈.
            1번째 글자부터 n개 글짜를 하나씩 갖다 붙이면서 계산 시작하는거임.
         */

        for (int i = 0; i < n; i++) {
            // 다음 글자(i+1번째)를 갖다 붙일 때 생길 상태들 담는 map임
            Map<Integer, Long> nextDp = new HashMap<>();

            // 지금까지 만들어진 모든 상태들을 하나씩 꺼내서 검사함.
            for (Map.Entry<Integer, Long> entry : dp.entrySet()) {
                int state = entry.getKey(); // 상태 번호 (이거는 고유값임. 아까 v1, v2, v3 어쩌구 그거로 계산한 그거임)
                long count = entry.getValue(); // 이 상태의 문자열이 몇개나 있는지?

                // 위에서 설명한 인코딩의 반대 (디코딩)로 되돌리는거임 (-2, -1, 0 중에 하나로)
                int v1 = (state / 9) % 3 - 2;
                int v2 = (state / 3) % 3 - 2;
                int v3 = state % 3 - 2;

                // 현재 index 기준으로 LCS 실제 값이 얼마인지 계산하는거임
                int val_minus1 = (i - 1) + v1; // LCS(T_i, S_i-1)
                int val_0 = i + v2;           // LCS(T_i, S_i)
                int val_plus1 = (i + 1) + v3; // LCS(T_i, S_i+1)

                // 이제 지금 완성된 문자열에 m개의 알파벳을 하나씩 다 붙여봄 (이거는 중복 제거하려고 하는거임)
                for (int c = 0; c < m; c++) {
                    char nextChar = (char) ('a' + c); // 이번에 붙여볼 문자

                    /*
                        붙일 문자가 앞, 뒤, 현재 문자랑 일치하는지 확인함.
                        이게 이해 안될 수 있는데, 같은 문자일 경우에 패턴이 똑같아지기 떄문에 제외해야 하는거임
                        ex)
                            abb가 있고, index가 1이라고 쳐보셈 (가운데 있는 b)
                            그러면 b를 c로 바꾸면 acb라서 문제가 없음.
                            근데 b를 앞의 문자랑 같은 a랑 바꾸면 aab임.
                            이 경우에 index 0, 2를 사용해서 ab 조합을 만드는거랑
                            index 1, 2를 사용해서 ab 조합을 만드는게 중복됨.
                            이 현상을 막기 위함임.
                     */

                    // (1이면 일치하는거고, 0이면 불일치하는거임)
                    int match1 = (i - 1 >= 0 && nextChar == S.charAt(i - 1)) ? 1 : 0;
                    int match2 = (i < n && nextChar == S.charAt(i)) ? 1 : 0;
                    int match3 = (i + 1 < n && nextChar == S.charAt(i + 1)) ? 1 : 0;

                    // lcs 전이 => (대각선+1 vs 왼쪽 vs 위) 이거로 다음칸 LCS 구함.
                    // T에 한 글자 추가했을 때, S_i까지의 새로운 LCS 점수
                    int nval_0 = Math.max(val_0, val_minus1 + match1);
                    // T에 한 글자 추가했을 때, S_i+1까지의 새로운 LCS 점수
                    int nval_plus1 = Math.max(val_plus1, Math.max(nval_0, val_0 + match2));
                    // T에 한 글자 추가했을 때, S_i+2까지의 새로운 LCS 점수
                    int nval_plus2 = Math.max(val_plus1, Math.max(nval_plus1, val_plus1 + match3));

                    // 구한 lcs 값들이 기준 위치 (i+1임)에서 얼마나 모자란지 다시금 계산함.
                    // 실제 값을 상대 값으로 다시 치환해주는거임
                    int nv1 = nval_0 - i;
                    int nv2 = nval_plus1 - (i + 1);
                    int nv3 = nval_plus2 - (i + 2);

                    // 만약 정중앙(nv2) 점수가 -1보다 더 낮아지면(예: -2),
                    // 앞으로 아무리 잘해도 LCS n-1을 만들 수 없으니 이 경우는 그만둠.
                    // 즉, nv2가 2이면 길이가 n-2인 상태임
                    if (nv2 < -1) continue;

                    // 점수 차이가 -2보다 더 벌어지는 경우를 대비해 하한선을 -2로 고정해줌.
                    // 점수가 낮게 나왔다고 땅굴파고 무한으로 떨어지는거 방지해주는거임.
                    nv1 = Math.max(-2, nv1);
                    nv2 = Math.max(-2, nv2);
                    nv3 = Math.max(-2, nv3);

                    // 새로 얻은 v1, v2, v3 상태를 다시 하나의 숫자로 압축함.
                    // 아까 설명했던 인코딩 다시 해주는거임.
                    int nextState = (nv1 + 2) * 9 + (nv2 + 2) * 3 + (nv3 + 2);

                    // 이 새로운 상태의 개수를 map에 누적해서 더해줌.
                    nextDp.put(nextState, nextDp.getOrDefault(nextState, 0L) + count);
                }
            }
            // 이제 한 글자 추가한거임.
            // 이제 다음 단계로 넘어가기 위해서 지금 만든 dp로 다음 수행할 dp를 치환해줌.
            dp = nextDp;
        }

        long answer = 0;
        for (Map.Entry<Integer, Long> entry : dp.entrySet()) {
            int state = entry.getKey();
            // 최종 단계(i=n)에서 메인 대각선 값(v2)이 딱 -1인 경우를 찾아야 함. (LCS = n - 1)
            int v2 = (state / 3) % 3 - 2;

            if (v2 == -1) {
                // 조건을 만족하는 모든 경우의 수를 정답에 더해줌.
                answer += entry.getValue();
            }
        }

        System.out.println(answer);
    }
}
