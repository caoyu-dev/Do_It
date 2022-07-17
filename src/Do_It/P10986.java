package Do_It;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
//        System.out.println("N --> " + N);
//        System.out.println("M --> " + M);

        int sum = 0;
        int[] cnt = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sum += Integer.parseInt(st.nextToken()) % M;
//            System.out.println("=======================");
//            System.out.println(i + "번째 도는 중");
//            System.out.println("sum --> " + sum);
//            System.out.println("=======================");
            cnt[sum % M]++;
//            System.out.println("cnt[" + sum % M + "]++ ==> " + cnt[sum % M]);
        }

        long ans = cnt[0];
        for (int i = 0; i < M; i++) {
            ans += (long) cnt[i] * (cnt[i] - 1) / 2;
//            System.out.println("=======================");
//            System.out.println("cnt[" + i + "] --> " + cnt[i]);
//            System.out.println("ans --> " + ans);
//            System.out.println("=======================");
        }
        System.out.println(ans);
    }
}
