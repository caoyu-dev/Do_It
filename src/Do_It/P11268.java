package Do_It;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class P11268 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println("N --> " + N);

        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> {
            int first_abs = Math.abs(a);
            int second_abs = Math.abs(b);
            if (first_abs == second_abs) {
                return a > b ? 1 : -1;
            } else {
                return first_abs - second_abs;
            }
        });
        System.out.println("q --> " + q);

        for (int i = 0; i < N; i++) {
            int ans = Integer.parseInt(br.readLine());
            if (ans == 0) {
                if (q.isEmpty()) {
                    System.out.println("0");
                } else {
                    System.out.println(q.poll());
                }
            } else {
                q.add(ans);
            }
        }
    }
}
