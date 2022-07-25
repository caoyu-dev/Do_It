package Do_It;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        System.out.println("N: " + N + ", arr: " + arr);

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            System.out.println("arr[" + i + "]: " + arr[i]);
        }

        Arrays.sort(arr);

        for (int value : arr) {
            sb.append(value).append("\n");
        }
        System.out.println(sb);
    }
}
