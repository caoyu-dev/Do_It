package Do_It;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] num = new int[N];
        System.out.println(num);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬
        Arrays.sort(num);

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            // 포인터 두 가지(start: 시작, end: 배열 끝)
            int start = 0;
            int end = N - 1;

            // 포인터 값 조건
            while (start < end) {
                if (start == i) {
                    start++;
                } else if (end == i) {
                    end--;
                } else {
                    int sum = num[start] + num[end];
                    if (sum == num[i]) {
                        cnt++;
                        break;
                    } else if (sum < num[i]) {
                        // num[i] > num[start] + num[end] 이면 start++
                        start++;
                    } else if (sum > num[i]) {
                        // num[i] < num[start] + num[end] 이면 end--
                        end--;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}
