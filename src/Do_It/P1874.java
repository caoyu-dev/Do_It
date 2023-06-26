package Do_It;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];

        StringBuilder sb = new StringBuilder();
        int idx = 0;
        int num = 1;

        //
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<Integer>();

        while (idx < N) {
            if (!stack.isEmpty() && arr[idx] < stack.get(stack.size() - 1)) {
                break;
            } else if (!stack.isEmpty() && arr[idx] == stack.get(stack.size() - 1)) {
                stack.pop();
                sb.append("-").append("\n");
                idx++;
            } else {
                while (num < N + 1) {
                    if (arr[idx] != num) {
                        stack.push(num);
                        sb.append("+").append("\n");
                        num++;
                    } else {
                        stack.push(num);
                        sb.append("+").append("\n");
                        num++;
                        break;
                    }
                }
            }
        }

        if (idx == N) {
            System.out.println(sb);
        } else {
            System.out.println("NO");
        }
    }
}
