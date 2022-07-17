package Do_It;

import java.util.Scanner;

public class P2018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        // 자기 자신도 연속된 수에 해당하기 때문에 한 가지 경우는 무조건 존재
        int cnt = 1;

        if (N <= 2) {
            System.out.println(1);
        } else {
            for (int i = 1; i < N/2 + 1; i++) {
                // 시작값 달라짐
                int sum = i;
                // i < N/2 + 1 성립하면 j++
                for (int j = i + 1; i < N/2 + 1; j++) {
                    // sum 이 N 보다 커지면 종료
                    if (sum > N) {
                        break;
                    }
                    // sum 이 N 과 같으면 cnt++
                    else if (sum == N){
                        cnt++;
                        break;
                    }
                    sum += j;
                }
            }
            System.out.println(cnt);
        }
    }
}
