package Do_It;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/**
 * 최악 다시 생각
 */
public class P11003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        System.out.println("N: " + N + ", L: " + L);

        ArrayDeque<Integer> dq = new ArrayDeque<>();
        int arr[] = new int[N];

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            System.out.println("dq --> " + dq);

            while (!dq.isEmpty() && arr[dq.peekLast()] > arr[i]) {
                System.out.println("arr[dq.peekLast()] ==> " + arr[dq.peekLast()] + ", arr[" + i + "] ==> " + arr[i]);
                dq.pollLast();
            }
            System.out.println("dq2 --> " + dq);

            dq.offer(i);

            if (i - dq.peekFirst() >= L) {
                System.out.println("dq.peekFirst() --> " + dq.peekFirst());
                dq.pollFirst();
            }
            System.out.println("dq3 --> " + dq);

            sb.append(arr[dq.peekFirst()]).append(" ");
            System.out.println("sb ==> " + sb);
        }
        System.out.println(sb);
    }
}
