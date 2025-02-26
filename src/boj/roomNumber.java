package boj;

import java.util.Scanner;

public class roomNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int sixNine = 0; // 6과 9의 갯수
        int[] count = new int[10];
        for (int i =0 ; i < s.length(); i++){
            int num = s.charAt(i) - '0';
            if(num == 6 || num == 9){
                sixNine++;
            }else{
                count[num]++; // 0~9까지의 갯수를 센다.
            }
        }
        int max =0;
        for(int i =0; i<10; i++){
            if(i == 6 || i == 9){
                continue;
            }
            max = Math.max(max, count[i]); // 0~9까지의 갯수중 가장 큰 수를 찾는다.
        }
        System.out.println(Math.max(sixNine%2 == 0 ? sixNine/2 : sixNine/2+1, max));

    }
}
