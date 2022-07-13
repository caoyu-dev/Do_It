package Do_It;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int arr[] = new int[n + 1];
//        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            arr[0] = 0;
            while(st.hasMoreTokens()) {
                arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
            }
            System.out.println("arr[" + i + "] = " + arr[i]);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

//            sb.append(arr[b] - arr[a - 1]).append("\n");
            System.out.println(arr[b] - arr[a - 1]);
        }
    }
}
