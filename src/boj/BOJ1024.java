package boj;

import java.util.Scanner;

public class BOJ1024 {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();

        for (int i = l; i <= 100; i++) {
            int x = n - i * (i - 1) / 2;
            if (x % i == 0 && x / i >= 0) {
                int start = x / i;
                for (int j = 0; j < i; j++) {
                    System.out.print(start + j + " ");
                }
                return;
            }
        }
        System.out.println(-1);


    }
}
