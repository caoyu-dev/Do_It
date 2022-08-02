package Do_It;

import java.util.Scanner;

/**
 * 100-40+50+74-30+29-45+43+11
 */
public class P1541 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 초기 상태 여부를 나타내기 위한 값 설정
        int sum = Integer.MAX_VALUE;
        String ex = sc.nextLine();
        String[] sub = ex.split("-");

        for (int i = 0; i < sub.length; i++) {
            int temp = 0;

            // 뺄셈으로 나뉘어진 배열을 덧셈을 하기 위한 배열로 다시 나눔
            String[] add = sub[i].split("\\+");

            // 덧셈을 하기 위해 나눈 배열을 더함
            for (int j = 0; j < add.length; j++) {
                temp += Integer.parseInt(add[j]);
            }

            // 초기 상태 여부와 비교
            if (sum == Integer.MAX_VALUE) {
                // 첫 번째 배열
                sum = temp;
            } else {
                // 이후 배열은 빼기
                sum -= temp;
            }
        }
        System.out.println(sum);
    }
}
