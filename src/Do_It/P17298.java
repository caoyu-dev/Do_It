package Do_It;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int A[] = new int[N];
        int ans[] = new int[N];
        String[] str = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(str[i]);
        }

        Stack<Integer> stack = new Stack<Integer>();

        stack.push(0);

        for (int i = 1; i < N; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            }

            while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
                ans[stack.pop()] = A[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            // 스택이 빌 때까지 -1
            ans[stack.pop()] = -1;
        }

        for (int i = 0; i < N; i++) {
            sb.append(ans[i] + " ");
        }
        System.out.println(sb);
    }
}
