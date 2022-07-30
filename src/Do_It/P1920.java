package Do_It;

import java.util.Arrays;
import java.util.Scanner;

public class P1920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        // arr 리스트 데이터 저장하기
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        // 오름차순 정렬(필수)
        Arrays.sort(arr);

        int M = sc.nextInt();
        int[] arr2 = new int[M];
        // arr2 리스트 데이터 저장하기
        for (int i = 0; i < M; i++) {
            arr2[i] = sc.nextInt();
        }

        // 이진 탐색(오름차순 정렬한 arr, arr2 간의 비교)
        for (int i = 0; i < M; i++) {
            System.out.println(binarySearch(arr, arr2[i]));
        }
    }


    private static int binarySearch(int[] arr, int num) {
        int start = 0;
        int end = arr.length - 1;
        // 중간값
        int mid = 0;

        // start = end 가 될 때까지
        while (start <= end) {
            mid = (start + end) / 2;

            // arr[mid] > arr2[i]
            if (arr[mid] > num) {
                end = mid - 1;
            }
            // arr[mid] < arr2[i]
            else if (arr[mid] < num) {
                start = mid + 1;
            }
            // arr[mid] == arr2[i]
            else if (arr[mid] == num){
                return 1;
            }
        }
        return 0;
    }
}
