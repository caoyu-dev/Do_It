package Do_It;

import java.util.Scanner;

public class P2343 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        int start = 0, end = 0;

        // arr 배열 저장
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            // arr 배열 총합
            // 모든 레슨 시간의 총합을 종료 인덱스로 지정
            end = end + arr[i];
            // arr 배열 중 최대값
            if (start < arr[i]) {
                // 레슨 최대값을 시작 인덱스로 지정
                start = arr[i];
            }
        }

        // arr 배열 중 최대값 = arr 배열 총합이 될 때까지
        while (start <= end) {
            // 중간 인덱스
            int mid = (start + end) / 2;
            // 레슨 시간 합
            int sum = 0;
            // 사용한 블루레이 개수
            int cnt = 0;

            for (int i = 0; i < N; i++) {
                // sum + 현재 레슨 시간 > 중간 인덱스이면
                if (sum + arr[i] > mid) {
                    // cnt 값 추가하고
                    cnt++;
                    // sum 은 초기화
                    sum = 0;
                }
                // sum 에 현재 레슨 시간을 더하기
                sum = sum + arr[i];
            }

            // sum 이 0 이 아니면 블루레이가 하나 더 필요하므로 cnt 추가
            if (sum != 0) {
                cnt++;
            }

            // cnt > M 인 경우, 중간 인덱스 값으로 모든 레슨 시간 저장 불가능
            if (cnt > M) {
                start = mid + 1;
            }
            // 중간 인덱스 값으로 모든 레슨 시간 저장 가능
            else {
                end = mid - 1;
            }
        }
        System.out.println(start);
    }
}
