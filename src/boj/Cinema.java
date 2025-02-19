package boj;
import java.util.Random;
import java.util.Scanner;

/*
   필수기능
   1. 좌석 정보를 조회할 수 있다.
   2. 좌석에 대한 예매가 가능해야한다.
   3. 예매 정보를 조회할 수 있다.
   4. 예매 취소
   5. 좌석 초기화

   + 영화관 필요한 기능 추가 2~3

   실행
   1. 예매
   ...
   5. 종료

 */
public class Cinema {

    private String[][] seat = new String[4][6];
    //   private String [][]reservationNumbers= new String[4][6];
//   private int seatNum1;
//   private int seatNum2;
    private int popconNum;

    Scanner sc = new Scanner(System.in);

    // 좌석 초기화
    private void seatReset() {
        for (int i = 0; i < seat.length; i++) {
            for (int j = 0; j < seat[i].length; j++) {
                // 좌석을 초기화
                seat[i][j] = "__";
//            reservationNumbers[i][j]="";

            }
        }
    }

    // 현재 좌석 조회
    private void seatCheck() {
        for (int i = 0; i < seat.length; i++) {
            for (int j = 0; j < seat[i].length; j++) {
                String a = Integer.toString(i + 1) + "-" + Integer.toString(j + 1);
                System.out.printf("[%s]", seat[i][j].equals("__") ? a : "X");
            }
            System.out.println();
        }
    }

    // 예매하기
    private void reservationSeat() {
        Random r = new Random();

        System.out.println("좌석을 선택해 주세요.  예)1-1");
        System.out.println("이미 예매된 좌석은 \"X\"라고 표시됩니다.");
        seatCheck();
        try {
            String input = sc.nextLine();
            String parts[] = input.split("-");
//         int seatNum1 = Integer.parseInt(parts[0]) - 1;
//         int seatNum2 = Integer.parseInt(parts[1]) - 1;

            int num1 = (Integer.parseInt(parts[0]));
            int num2 = (Integer.parseInt(parts[1]));
            if (!seat[num1 - 1][num2 - 1].equals("__")) {
                System.out.println("이미 예매된 좌석입니다.");
            } else {
                System.out.println("예매 가능합니다. 예매 하시겠습니까?");
                System.out.println("네(1), 아니오(2), 초기화면(0)중 하나를 눌러주세요");
                int inputData = Integer.parseInt(sc.nextLine());
                switch (inputData) {
                    case 1:
                        System.out.println("예매가 완료 되었습니다.");
                        String reservationNum = "";
                        for (int i = 0; i < 10; i++) {
                            reservationNum += Integer.toString(r.nextInt(9) + 1);
                        }
                        System.out.printf("예매한 좌석번호 : [%d - %d] / 예매번호 : [%s]", num1, num2, reservationNum);
                        System.out.println();
                        seat[num1 - 1][num2 - 1] = reservationNum;

                        System.out.println("==================================");
                        System.out.println("영화와 함께 팝콘을 구매하시겠습니까?!");
                        System.out.println("네(1), 아니오(2), 초기화면(0)중 하나를 눌러주세요");

                        int popconData = Integer.parseInt(sc.nextLine());

                        switch (popconData) {
                            case 1:
                                System.out.println("구매할 팝콘 수량을 입력해주세요:");
                                popconNum = Integer.parseInt(sc.nextLine());
                                System.out.printf("팝콘 [%s]개 구매완료 되었습니다.", popconNum);
                                break;
                            case 2:
                                System.out.println("팝콘을 구매하지 않았습니다.");
                                break;
                        }
                        break;

                    case 2:
                        reservationSeat();
                        break;
                    case 0:
                        viewMenu();
                        break;

                }

            }
        } catch (Exception e) {
            System.out.println("[ERROR] 잘못된 접근입니다.");

        }

    }

    // 메뉴 화면
    private void viewMenu() {
        System.out.println("***************************");
        System.out.println("*****영화 예매 시스템*****");
        System.out.println("1.좌석 정보 조회");
        System.out.println("2. 좌석 예매하기");
        System.out.println("3. 예매 정보 조회");
        System.out.println("4. 예매 취소");
        System.out.println("5. 좌석 초기화");
        System.out.println("6. 좌석 변경");
        System.out.println("7. 시스템 종료");
    }

    // 실행
    public int run() {
        seatReset();
        do {
            viewMenu();
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1: // 좌석정보 조회 함수 출력
                    seatCheck();
                    break;
                case 2: // 죄석 예매하기
                    reservationSeat();
                    break;
                case 3: // 예매 정보 조회
                    reservationNumCheck();
                    break;
                case 4: // 예매 취소
                    cancelReservation();
                    break;
                case 5: // 좌석 초기화
                    seatReset();
                    break;
                case 6: // 시스템 종료
                    seatChange();
                    break;
                case 7: // 시스템 종료
                    return 0;
                default:
                    System.out.println("잘못된 번호를 입력했습니다.");
            }

        }

        while (true);

    }

    // 좌석 변경
    private void seatChange() {
        reservationNumCheck();
        seatCheck();

        String reservationNum = "";
        System.out.println("자리를 변경하시려면 네(1) , 아니오(2) 중 하나를 입력해주세요.");
        int inputNum = Integer.parseInt(sc.nextLine()); // 사용자 입력 받기
        if (inputNum == 1) {
            boolean t = true;
            while (t) {
                for (int i = 0; i < seat.length; i++) {
                    for (int j = 0; j < seat[i].length; j++) {
                        if (!seat[i][j].equals("__")) {
                            reservationNum = seat[i][j];
                            seat[i][j] = "__";
                            System.out.println("예매가 취소되었습니다. 감사합니다.");
                            t = false;
                            i = seat.length - 1;
                            break;
                        }
                    }
                }
            }
            System.out.println("변경할 좌석으로 입력주세요");
            String input = sc.nextLine();
            String parts[] = input.split("-");

            int num1 = (Integer.parseInt(parts[0]));
            int num2 = (Integer.parseInt(parts[1]));
            if (!seat[num1 - 1][num2 - 1].equals("__")) {
                System.out.println("이미 예매된 좌석입니다.");
            } else {
                System.out.println("변경 가능합니다. 예매 하시겠습니까?");
                System.out.println("네(1), 아니오(2), 초기화면(0)중 하나를 눌러주세요");
                int inputData = Integer.parseInt(sc.nextLine());
                switch (inputData) {
                    case 1:
                        System.out.println("예매가 완료 되었습니다.");
                        System.out.printf("예매한 좌석번호 : [%d - %d] / 예매번호 : [%s]", num1, num2, reservationNum);
                        System.out.println();
                        seat[num1 - 1][num2 - 1] = reservationNum;
                        break;
                    case 2:
                        reservationSeat();
                        break;
                    case 0:
                        break;
                }

            }
//      if (inputNum == 1) {
//         seat[seatNum1][seatNum2] = "__";
//
        }
    }

    // 예매 취소
    private void cancelReservation() {
        reservationNumCheck();
        System.out.println("예매를 취소하시겠습니까?");
        System.out.println("네(1) , 아니오(2) 중 하나를 입력해주세요.");

        int inputNum = Integer.parseInt(sc.nextLine()); // 사용자 입력 받기

        if (inputNum == 1) {
            boolean t = true;
            while (t) {
                for (int i = 0; i < seat.length; i++) {
                    for (int j = 0; j < seat[i].length; j++) {
                        if (!seat[i][j].equals("__")) {
                            seat[i][j] = "__";
                            System.out.println("예매가 취소되었습니다. 감사합니다.");
                            t = false;
                            i = seat.length - 1;
                            break;
                        }
                    }
                }
            }

        }
    }

    public void reservationNumCheck() {
        boolean t = true;
        while (t) {
            System.out.println("예매 번호를 입력해주세요");
            String check = sc.nextLine();
            for (int i = 0; i < seat.length; i++) {
                for (int j = 0; j < seat[i].length; j++) {
                    if (check.equals(seat[i][j])) {
                        System.out.printf("고객님이 예매하신 좌석은 [%d-%d]입니다\n", i + 1, j + 1);
                        if (popconNum > 0) {
                            System.out.printf("팝콘은 [%d]개 구매하셨습니다.\n", popconNum);
                        }
                        t = false;
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Cinema ci = new Cinema();
        ci.run();
    }
}
