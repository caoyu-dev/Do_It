package Do_It;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 주석 넣기
 */
public class P1517 {
    public static long cnt;
    public static int[] arr, temp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println("N: " + N);

        arr = new int[N + 1];
        temp = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            System.out.println("arr[" + i + "]: " + arr[i]);
        }
        cnt = 0;
        merge_sort(1, N);
        System.out.println(cnt);
    }

    private static void merge_sort(int start, int end) {
        if (end - start < 1) {
            return;
        }
        int point = start + (end - start) / 2;
        merge_sort(start, point);
        merge_sort(point + 1, end);
        for (int i = start; i <= end; i++) {
            temp[i] = arr[i];
        }
        int k = start;
        int idx1 = start;
        int idx2 = point + 1;
        while (idx1 <= point && idx2 <= end) {
            if (temp[idx1] > temp[idx2]) {
                arr[k] = temp[idx2];
                cnt = cnt + idx2 - k;
                k++;
                idx2++;
            } else {
                arr[k] = temp[idx1];
                k++;
                idx1++;
            }
        }
        while (idx1 <= point) {
            arr[k] = temp[idx1];
            k++;
            idx1++;
        }
        while (idx2 <= end) {
            arr[k] = temp[idx2];
            k++;
            idx2++;
        }
    }
}
