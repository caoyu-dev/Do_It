package Do_It;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2023 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dfs(0, N);
    }

    private static void dfs(int num, int N) {
        if (N == 0) {
            System.out.println(num);
        }
        for (int i = 1; i <= 9; i++) {
            // DFS 로 각 자릿수(깊이) 체크
            int temp = 10 * num + i;
            if (N > 0 && isPrime(temp)) {
                dfs(temp, N - 1);
            }
        }
    }

    /**
     * 소수 판별식 -> 에라토스테네스
     */
    private static boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }
        int sqt = (int) Math.sqrt(num);
        for (int i = 2; i <= sqt; i++) {
            // i 의 배수이면 소수가 아님
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
