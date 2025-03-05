package boj;

import java.util.Scanner;

public class stack10828 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] stack = new int[n];
        int top = -1;

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split(" ");
            switch (input[0]) {
                case "push":
                    stack[++top] = Integer.parseInt(input[1]);
                    break;
                case "pop":
                    if (top == -1) {
                        System.out.println(-1);
                    } else {
                        System.out.println(stack[top--]);
                    }
                    break;
                case "size":
                    System.out.println(top + 1);
                    break;
                case "empty":
                    System.out.println(top == -1 ? 1 : 0);
                    break;
                case "top":
                    if (top == -1) {
                        System.out.println(-1);
                    } else {
                        System.out.println(stack[top]);
                    }
                    break;
            }
        }
        sc.close();
    }
}
