package Do_It;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class P1744 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        ArrayList<Integer> plus = new ArrayList<>();
        ArrayList<Integer> minus = new ArrayList<>();

        // 카운드 변수
        int zero = 0;
        int one = 0;

        // 양수, 1, 음수 기준으로 숫자 분류
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            if (num > 1) {
                plus.add(num);
            } else if (num == 1) {
                one++;
            } else if (num < 0) {
                minus.add(num);
            } else {
                zero++;
            }
        }
        Collections.sort(plus);
        Collections.reverse(plus);  // 양수는 내림차순
        Collections.sort(minus);    // 음수는 오름차순

        // 양수 배열 크기가 홀수일 때, 1 추가
        // 어차피 1 은 곱해도 값 변화 없음
        if (plus.size() % 2 == 1) {
            plus.add(1);
        }
        // 음수 배열 크기가 홀수일 때,
        if (minus.size() % 2 == 1) {
            // 0 이 한 개 이상 있는 경우 0 추가
            if (zero > 0) {
                minus.add(0);
            } else {
                minus.add(1);
            }
        }

        // 결과값은 양수 기준으로 계산
        int ans = one;
        for (int i = 0; i < plus.size(); i += 2) {
            ans += plus.get(i) * plus.get(i + 1);
        }
        for (int i = 0; i < minus.size(); i += 2) {
            ans += minus.get(i) * minus.get(i + 1);
        }
        System.out.println(ans);
    }
}
