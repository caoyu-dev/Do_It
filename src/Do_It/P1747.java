package Do_It;

import java.util.Scanner;

public class P1747 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = n; ; i++) {
            if (isPalindrome(i) && isPrime(i)) {
                System.out.println(i);
                break;
            }
        }
    }

    /**
     * 입력한 숫자를 문자열로 변경해서 첫 문자와 마지막 문자에서 시작해
     * 한 자리씩 이동하며 문자가 달라지는 순간 팰린드롬 false 추출
     */
    private static boolean isPalindrome(int n) {
        String num = Integer.toString(n);
        for (int i = 0; i <= num.length() / 2; i++) {
            if (num.charAt(i) != num.charAt(num.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 에라토스테네스 체 알로리즘 .
     */
    private static boolean isPrime(int n) {
        if(n == 1) return false;
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
