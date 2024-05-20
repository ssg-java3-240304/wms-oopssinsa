package com.oopssinsa.view;

import com.oopssinsa.controller.MenuController;
import com.oopssinsa.model.dto.AccountDto;
import com.oopssinsa.model.dto.IbDetailDto;
import com.oopssinsa.model.dto.ProductDto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MenuView {
    private MenuController menuController = new MenuController();
    private Scanner sc = new Scanner(System.in);
    private AccountDto accountDto = null;
    public void mainMenu() {
        // id 입력받아 해당하는 회원정보 보기 -> 로그인 기능
        while (accountDto == null) {
            accountDto = menuController.login(loginId(), loginPassword());
        }
        System.out.println(accountDto);
//        String Id = (Long.toString(accountDto.getBrandId())) + LocalDate.now().format(DateTimeFormatter.ofPattern("YYMMdd"));
//        System.out.println(Id);


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
                case "3" : menuController.findByUserId(accountDto.getId()); break;
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
        // 입고 ID
        String Id1 = (Long.toString(accountDto.getBrandId())) + LocalDate.now().format(DateTimeFormatter.ofPattern("YYMMdd"));
        long id = Long.parseLong(Id1);
        System.out.println("제조일자 (YYYY-MM-dd) : ");
        String manufactureDateStr = sc.next();
        LocalDate manufactureId = LocalDate.parse(manufactureDateStr);
        System.out.println("상품 ID : ");
        String productId = sc.next();
        // 발주자 ID
        String loginId = accountDto.getId();
        System.out.println("수량 : ");
        int quantity = sc.nextInt();
        // null값인 행도 적어줘야 되는지?
        LocalDate ibRequestDate = null;
        LocalDate completionDate = null;
        String status = null;
        return new IbDetailDto(id, manufactureId, productId, loginId, quantity, ibRequestDate, completionDate, status);
    }

    private ProductDto inputProduct() {
        System.out.println("> ✏✏✏ 등록할 상품정보를 작성해주세요. ✏✏✏");
        System.out.println("상품 ID : ");
        String id = sc.next();
        // 브랜드 ID
        long brandId = accountDto.getBrandId();
        System.out.println("카테고리 ID : ");
        long categoryId = sc.nextLong();
        System.out.println("상품 이름 : ");
        String name = sc.next();
        System.out.println("사이즈 : ");
        String size = sc.next();
        System.out.println("색상 : ");
        String color = sc.next();
        System.out.println("부피 : ");
        int volume = sc.nextInt();
        return new ProductDto(id, brandId, categoryId, name, size, color, volume);
    }

    //    private AccountDto login() {
//        System.out.print("ID를 입력해 주세요 : ");
//        String id = sc.next();
//        System.out.print("비밀번호를 입력해 주세요 :");
//        String password = sc.next();
//        return new AccountDto(id, password);
//    }
    private String loginId() {
        System.out.println("==================================================================");
        System.out.print("ID를 입력해 주세요 : ");
        String id = sc.next();
        return id;
    }

    private String loginPassword() {
        System.out.print("비밀번호를 입력해 주세요 :");
        String password = sc.next();
        return password;
    }

}
