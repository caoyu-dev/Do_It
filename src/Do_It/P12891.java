package Do_It;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P12891 {
    static int ans;
    static String str;
    static Map<Character, Integer> dna;
    public static void main(String[] args) throws IOException {
        ans = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        str = br.readLine();

        // 단위 음수로 시작하여 0 이상이 되면 성립
        dna = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        dna.put('A', -Integer.parseInt(st.nextToken()));
        dna.put('C', -Integer.parseInt(st.nextToken()));
        dna.put('G', -Integer.parseInt(st.nextToken()));
        dna.put('T', -Integer.parseInt(st.nextToken()));

        // + 로직
        add(0, P);

        int start = 0;
        int end = P;
        while (true) {
            // 모든 값 0 이상이면 ans++
            checkAns();

            // end 값이 문자열 보다 큰 경우
            if (end >= S) {
                break;
            }

            // - 로직 => 앞에서 하나 빠지면
            remove(start, start + 1);
            // + 로직 => 뒤에서 하나 붙어야 함
            add(end, end + 1);

            // 한 칸씩 뒤로 밀림
            start++;
            end++;
        }
        System.out.println(ans);
    }

    private static void checkAns() {
        for (Integer value : dna.values()) {
            if (value < 0) {
                return;
            }
        }
        ans++;
    }

    private static void remove(int start, int end) {
        for (int i = start; i < end; i++) {
            dna.compute(str.charAt(i), (character, integer) -> integer - 1);
        }
    }

    private static void add(int start, int end) {
        for (int i = start; i < end; i++) {
            dna.compute(str.charAt(i), (character, integer) -> integer + 1);
        }
    }
}
