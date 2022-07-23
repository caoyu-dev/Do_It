package Do_It;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * StringBuilder 를 사용하지 않는 경우 -> 시간 초과 // 고민
 */
public class P2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        System.out.println(N);

        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(br.readLine()));
            System.out.println(arr);
        }
        System.out.println(arr);
        Collections.sort(arr);
        System.out.println(arr);

        for (int value : arr) {
            sb.append(value).append("\n");
        }
        System.out.println(sb);
    }
}
