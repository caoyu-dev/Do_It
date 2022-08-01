package Do_It;

import java.util.PriorityQueue;
import java.util.Scanner;

public class P1715 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            pq.add(num);
        }
        int num1 = 0;
        int num2 = 0;
        int sum = 0;

        // 우선순위 큐에 2개 이상의 값이 있어야 비교 가능s
        while (pq.size() > 1) {
            num1 = pq.poll();
            num2 = pq.poll();

            // 2개 카드 묶음을 합치는 데 필요한 비교 횟수를 결과값에 더함
            sum += num1 + num2;

            // 2개 카드 묶음의 합을 우선순위 큐에 집어넣음(add 연산)
            pq.add(num1 + num2);
        }
        System.out.println(sum);
    }
}
