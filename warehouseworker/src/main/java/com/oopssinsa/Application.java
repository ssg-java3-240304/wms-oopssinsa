package com.oopssinsa;

import com.oopssinsa.controller.IbController;
import com.oopssinsa.controller.LoginController;
import com.oopssinsa.controller.ObController;
import com.oopssinsa.model.service.StockService;
import com.oopssinsa.view.LoginView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }

    public void run(){
        String workerId = null;
        /*

        // 예작시
//        LoginView loginView = new LoginView();
//
//        while (workerId==null) {
//            workerId = loginView.inputLogin();
//        }
        // 예작끝
         */
        LoginController loginController = new LoginController();
        IbController ibController = new IbController();
        ObController obController = new ObController();
        StockService stockService = new StockService();
        //최초 1회 로그인 및 workerId에 로그인 된 아이디 저장. 로그인이 실패했다면 workerId==null
        //아래 while loop은 로그인이 성공한 경우만 빠져나온다.

        while(workerId==null){
            workerId=loginController.loginValidation();
        }

        ibController.setWorkerId(workerId);
        obController.setWorkerId(workerId);
        String choice;
        //로그인 성공 후 창고 작업자 기능
        while(true){
            Scanner scanner = new Scanner(System.in);
            System.out.print(mainMenu);
            choice = scanner.nextLine();

            switch (choice){
                case "1":
                    ibController.getIbInstructionToDo();
                    break;
                case "2":
                    ibController.updateIbStatus();
                    break;
                case "3":
                    obController.getObInstructionToDo();
                    break;
                case "4":
                    obController.updateObStatus();
                    break;
                case "0":
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }


        }
    }
    static final String mainMenu= """
            ---------------------------------------------------------------------------
            1. 입고 지시 목록
            2. 입고 지시 처리
            3. 출고 지시 목록
            4. 출고 지시 처리
            0. 프로그램 종료
            ---------------------------------------------------------------------------
            기능 입력 : """;

}
