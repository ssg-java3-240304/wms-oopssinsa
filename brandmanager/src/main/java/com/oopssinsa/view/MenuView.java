package com.oopssinsa.view;

import com.oopssinsa.controller.MenuController;
import com.oopssinsa.model.dto.AccountDto;
import com.oopssinsa.model.dto.IbDetailDto;
import com.oopssinsa.model.dto.ProductDto;

import java.util.Scanner;

public class MenuView {
    private MenuController menuController = new MenuController();
    private Scanner sc = new Scanner(System.in);
    private AccountDto accountDto = null;
    public void mainMenu() {
        // id 입력받아 해당하는 회원정보 보기 -> 로그인 기능
        while (accountDto == null) {
            accountDto = menuController.login(login());
        }
        System.out.println(accountDto);

        String menu = """
                ==================================================================
                1. 상품 등록
                2. 입고 요청
                3. 입고 조회
                4. 출고 요청
                5. 출고 조회
                6. 전체 재고 현황 조회
                7. 카테고리별 재고 조회
                0. 종료
                ==================================================================
                입력 : """;
        while (true) {
            System.out.print(menu);
            String choice = sc.next();
            switch (choice) {
                case "1" : menuController.insertProduct(inputProduct()); break;
                case "2" : menuController.ibRequest(inputIbRequest()); break;
                case "3" : break;
                case "4" : break;
                case "5" : break;
                case "6" : break;
                case "7" : break;
                case "0" : return;
                default:
                    System.out.println("잘못 입력하셨습니다...");
            }
        }
    }

    private IbDetailDto inputIbRequest() {
        System.out.println("> ✏✏✏ 입고 요청서를 작성해주세요. ✏✏✏");
        System.out.println("입고 ID : ");
        int Id = sc.nextInt();
        System.out.println("제조일자 : ");
        int manufactureId = sc.nextInt();
        System.out.println("상품 ID : ");
        int productId = sc.nextInt();
        System.out.println("발주자 ID : ");
        String loginId = sc.next();
        System.out.println("수량 : ");
        int quantity = sc.nextInt();
        // null값인 행도 적어줘야 되는지?
//        LocalDate ibRequestDate = null;
        return new IbDetailDto(Id, manufactureId, productId, loginId, quantity);
    }

    private ProductDto inputProduct() {
        System.out.println("> ✏✏✏ 등록할 상품정보를 작성해주세요. ✏✏✏");
        System.out.println("상품 ID : ");
        String Id = sc.next();
        System.out.println("브랜드 ID : ");
        int brandId = sc.nextInt();
        System.out.println("카테고리 ID : ");
        int categoryId = sc.nextInt();
        System.out.println("상품 이름 : ");
        String name = sc.next();
        System.out.println("사이즈 : ");
        String size = sc.next();
        System.out.println("색상 : ");
        String color = sc.next();
        System.out.println("부피 : ");
        int volume = sc.nextInt();
        return new ProductDto(Id, brandId, categoryId, name, size, color, volume);
    }

    //    private AccountDto login() {
//        System.out.print("ID를 입력해 주세요 : ");
//        String id = sc.next();
//        System.out.print("비밀번호를 입력해 주세요 :");
//        String password = sc.next();
//        return new AccountDto(id, password);
//    }
    private String login() {
        System.out.println("==================================================================");
        System.out.print("ID를 입력해 주세요 : ");
        String id = sc.next();
        System.out.print("비밀번호를 입력해 주세요 :");
        String password = sc.next();
        return id;
    }
}
