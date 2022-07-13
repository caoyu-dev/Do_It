package Do_It;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        // 개행
        StringTokenizer st = new StringTokenizer(br.readLine());

        int max = 0;
        double sum = 0;
        double avg = 0;
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(st.nextToken());
            if (max < value) {
                max = value;
            }
            sum += value;
        }
        avg = sum / max * 100 / n;
        System.out.println(avg);
    }
}
