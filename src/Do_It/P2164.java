package Do_It;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2164 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Queue<Integer> q = new LinkedList<>();
        int N = in.nextInt();

        for (int i = 1; i < N + 1; i++) {
            q.offer(i);
        }

        while (q.size() > 1) {
            q.poll();           // 제일 앞 원소 버리고
            q.offer(q.poll());  // 제일 앞 원소 버린 후 그 다음 원소를 제일 뒤로 삽입
        }

        System.out.println(q.poll()); // 남은 원소 출력
    }
}
