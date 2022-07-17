package Do_It;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 재료의 개수: N, 필요한 개수: M
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] armor = new int[N];

        // 재료의 개수 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            armor[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        for (int start = 0; start < N; start++) {
            int sum = 0;
            int end = start + 1;

            // end 값이 재료의 개수보다 작으면 `end 값 + 1`
            while (end < N) {
                sum = armor[start];
                sum += armor[end++];

                // armor[start] + armor[end] == M 이면 cnt++
                if (sum == M) {
                    cnt++;
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
}
