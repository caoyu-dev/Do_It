package Do_It;

import java.util.Scanner;


public class P1929 {
    static boolean[] prime;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();

        prime = new boolean[end + 1];
        get_prime();

        for (int i = start; i < end + 1; i++) {
            // false 인 경우 소수
            if (!prime[i]) {
                System.out.println(i);
            }
        }
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
