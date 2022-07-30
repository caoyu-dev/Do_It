package Do_It;

import java.util.Scanner;

public class P1300 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        // left <= x <= right
        long left = 1;
        long right = K;
        long ans = 0;

        // 이진 탐색
        // left = right 가 될 때까지
        while (left <= right) {
            long mid = (left + right) / 2;
            // 중앙값 보다 작은 수
            long cnt = 0;

            // *** 별 백 개 *** 
            // 임의의 x 에 대해 i 번째 행을 나눈 후 x 보다 작거나 같은 원소의 개수의 누적 합
            // 단, 각 행의 원소의 개수가 N 을 초과하지 않아야 한다.
            for (int i = 1; i < N + 1; i++) {
                cnt = cnt + Math.min(mid / i, N);
            }

            // 중앙값 보다 작은 수 < right 이면
            if (cnt < K) {
                left = mid + 1;
            }
            // 중앙값 보다 작은 수 >= right 이면
            else {
                right = mid - 1;
                ans = mid;
            }
        }
        System.out.println(ans);
    }
}
