package Do_It;

import java.util.Arrays;
import java.util.Scanner;

public class P1931 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int timeTable[][] = new int[N][2];
        for (int i = 0; i < N; i++) {
            timeTable[i][0] = sc.nextInt();
            timeTable[i][1] = sc.nextInt();
        }
        // System.out.println("timeTable 1 --> " + Arrays.deepToString(timeTable));
        // 종료 시간이 같을 경우 시작 시간이 빠른 순으로 나열
        Arrays.sort(timeTable, (a,b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        int ans = 0;
        int time = 0;
        for (int i = 0; i < N; i++) {
            // 다음 회의 시작 시각 >= 이전 회의 종료 시각
            if (timeTable[i][0] >= time) {
                time = timeTable[i][1];
                ans++;
            }
        }
        System.out.println(ans);
    }
}
