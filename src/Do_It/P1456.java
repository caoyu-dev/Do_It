package Do_It;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class P1456 {
    static boolean[] prime;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        int max = 1000000;

        prime = new boolean[max + 1];
        get_prime();

        int cnt = 0;
        ArrayList<Long> list = new ArrayList<>();
        for (int i = 2; i <= max; i++) {
            if (end <= i) {
                break;
            }
            if (!prime[i]) {
                for (int j = 2; true; j++) {
                    if ((long) Math.pow(i, j) > end) {
                        break;
                    }
                    list.add((long) Math.pow(i, j));
                }
            }
        }
        Collections.sort(list);
        System.out.println(cnt);
    }

    // 에라토스테나스 체 알고리즘
    private static void get_prime() {
        // true 인 경우 소수가 아님, false 인 경우 소수
        prime[0] = prime[1] = true;

        for (int i = 2; i <= Math.sqrt(prime.length); i++) {
            if (prime[i]) {
                continue;
            }
            // 각 수의 배수 가능성 체크
            for (int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }
    }
}
