package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class countOfNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num1 = Integer.parseInt(br.readLine());
        int num2 = Integer.parseInt(br.readLine());
        int num3 = Integer.parseInt(br.readLine());

        int result = num1 * num2 * num3;
        String str = Integer.toString(result);
        int[] count = new int[10];

        String[] strArr = str.split("");

        for (String s : strArr) {
            int digit = Integer.parseInt(s);
            count[digit]++;
        }

        // 결과 출력
        for (int i = 0; i < 10; i++) {
            System.out.println(count[i]);
        }
    }
}
