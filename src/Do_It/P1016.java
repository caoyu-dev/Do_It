package Do_It;

import java.util.Scanner;

public class P1016 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long min = sc.nextLong();
        long max = sc.nextLong();

        // 최댓값과 최솟값 배열 차이만큼 배열 선언하기
        // false : 제곱이 아닌 수, true : 제곱인 수
        boolean[] check = new boolean[(int) (max - min + 1)];

        // 2 의 제곱수인 4 부터 max 보다 작거나 같은 값까지 반복하기
        for (long i = 2; i * i <= max; i++) {
            long pow = i * i;
            long start_idx = min / pow;
            if (min % pow != 0) {
                start_idx++;
            }
            // 제곱수를 true 로 변경하기
            for (long j = start_idx; j * pow <= max; j++) {
                check[(int) ((j * pow) - min)] = true;
            }
        }
        int cnt = 0;
        for (int i = 0; i <= max - min; i++) {
            if (!check[i]) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
