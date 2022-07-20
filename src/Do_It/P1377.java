package Do_It;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1377 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Arr[] arr = new Arr[N];

        // 배열
        for (int i = 0; i < N; i++) {
            arr[i] = new Arr();
            arr[i].idx = i;
            arr[i].value = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        // 몇 번 돌았는지 파악 -> 뒤에서 앞으로 오는 것 기준으로 생각해야 이해가 쉬움
        int max = 0;
        for (int i = 0; i < N; i++) {
            if (max < arr[i].idx - i) {
                max = arr[i].idx - i;
            }
        }
        System.out.println(max + 1);
    }
}
class Arr implements Comparable<Arr> {
    int idx;
    int value;

    @Override
    public int compareTo(Arr o) {
        return this.value - o.value;
    }
}
