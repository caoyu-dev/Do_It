package Do_It;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println("str: " + str.length());

        String[] arr = str.split("");
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < str.length(); j++) {
                if (Integer.parseInt(arr[i]) >= Integer.parseInt(arr[j])) {
                    String temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    System.out.println("arr[" + i + "]: " + arr[i] + ", arr[" + j + "]: " + arr[j]);
                }
            }
        }

        StringBuilder value = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            value.append(arr[i]);
        }
        System.out.println(value);
    }
}
