package com.oopssinsa.view;

import com.oopssinsa.controller.MenuController;
import com.oopssinsa.model.dto.AccountDto;
import com.oopssinsa.model.dto.IbDetailDto;
import com.oopssinsa.model.dto.ObDetailDto;
import com.oopssinsa.model.dto.ProductDto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Scanner;

public class MenuView {
    private MenuController menuController = new MenuController();
    private Scanner sc = new Scanner(System.in);
    private AccountDto accountDto = null;
    private ProductDto productDto = null;
    public void mainMenu() {
        System.out.println("📦 OOPSINSA WMS 서비스입니다 📦");
        // id 입력받아 해당하는 회원정보 보기 -> 로그인 기능
        while (accountDto == null || !Objects.equals(accountDto.getRole(), "BM")) {
            accountDto = menuController.login(loginId(), loginPassword());
        }
//        System.out.println(accountDto);
//        String Id = (Long.toString(accountDto.getBrandId())) + LocalDate.now().format(DateTimeFormatter.ofPattern("YYMMdd"));
//        System.out.println(Id);




        String menu = """
                ==================================================================
                ⚙️⚙️⚙️ 브랜드 매니저 메뉴 ⚙️⚙️⚙️
                ==================================================================
                1. 상품 등록
                2. 입고 요청
                3. 입고 요청 조회
                4. 출고 요청
                5. 출고 처리 조회
                6. 전체 재고 현황 조회
                7. 카테고리별 재고 조회
                8. 상품별 재고 조회
                0. 종료
                ==================================================================
                입력 : """;
        while (true) {
            System.out.print(menu);
            String choice = sc.next();
            switch (choice) {
                case "1" : menuController.insertProduct(inputProduct()); break;
                case "2" : menuController.ibRequest(inputIbRequest()); break;
                case "3" : menuController.findByUserId(findByUserId()); break;
                case "4" : menuController.obRequest(inputObRequest()); break;
                case "5" : menuController.findObDetail(findObDetail()); break;
                case "6" : menuController.findAllStockDetail(brandId()); break;
                case "7" : menuController.findStockByCategoryId(brandId(), categoryId()); break;
                case "8" : menuController.findStockByProductId(brandId(), productId()); break;
                case "0" : return;
                default:
                    System.out.println("잘못 입력하셨습니다...");
            }
        }
    }

    private String productId() {
        System.out.println("조회할 상품의 ID : ");
        return sc.next();
    }

    private long categoryId() {
        displayCategoryList();
        System.out.println("조회할 상품의 카테고리 ID : ");
        return sc.nextLong();
    }

    private long brandId() {
        return accountDto.getBrandId();
    }

    private String findObDetail() {
        System.out.println("==================================================================");
        System.out.println(accountDto.getName() + "님의 출고 처리 현황입니다.");
        return accountDto.getId();
    }


    private ObDetailDto inputObRequest() {
        System.out.println("> ✏✏✏ 출고 요청서를 작성해주세요. ✏✏✏");
        // 출고 ID
        String Id1 = (Long.toString(accountDto.getBrandId())) + LocalDate.now().format(DateTimeFormatter.ofPattern("YYMMdd"));
        long id = Long.parseLong(Id1);
        System.out.println("상품 ID : ");
        String productId = sc.next();
        // 발주자 ID
        String loginId = accountDto.getId();
        System.out.println("수량 : ");
        int quantity = sc.nextInt();
        System.out.println("수령인 : ");
        String recipientName = sc.next();
        sc.nextLine();
        System.out.println("배송지 : ");
        String address = sc.nextLine();
        // 출고요청일자
        LocalDate obDate = LocalDate.now();
        return new ObDetailDto(id, productId, loginId, quantity, recipientName, address, obDate);
    }


    private String findByUserId() {
        System.out.println("==================================================================");
        System.out.println(accountDto.getName() + "님의 입고 요청 현황입니다.");
        return accountDto.getId();
    }


    private IbDetailDto inputIbRequest() {
        menuController.showProduct(accountDto.getBrandId());

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
        LocalDate ibRequestDate = LocalDate.now();
        LocalDate completionDate = null;
        String status = "R";
        return new IbDetailDto(id, manufactureId, productId, loginId, quantity, ibRequestDate, completionDate, status);
    }

    private ProductDto inputProduct() {
        // 현재 등록된 상품 리스트
        menuController.showProduct(accountDto.getBrandId());

        System.out.println("> ✏✏✏ 등록할 상품정보를 작성해주세요. ✏✏✏");
        System.out.println("상품 ID : ");
        String id = sc.next();
        // 브랜드 ID
        long brandId = accountDto.getBrandId();
        displayCategoryList();
        System.out.println("카테고리 ID : ");
        long categoryId = sc.nextLong();
        sc.nextLine();
        System.out.println("상품 이름 : ");
        String name = sc.nextLine();
        String sizeMenu = """
                ---------------------------------------------------------------------
                                               사이즈 표                           
                ---------------------------------------------------------------------
                | Free = F | Small = S | Medium = M | Large = L | Extra Large = XL |
                ---------------------------------------------------------------------
                """;
        System.out.println(sizeMenu);
        System.out.println("사이즈 : ");
        String size = sc.next();
        System.out.println("색상 (검정색 = Black, 하얀색 = White ...) : ");
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

    private long loginBrandId() {
        return accountDto.getBrandId();
    }

    private void displayCategoryList() {
        String categoryMenu= """
                ---------------------------
                 카테고리 ID     카테고리 이름
                ---------------------------
                  1001      |   티셔츠
                  1002      |   니트/스웨터
                  2001      |   운동복 상의
                  2002      |   운동복 하의
                  3001      |   재킷/아우터
                  4001      |   신발
                  5001      |   블라우스/셔츠
                  5002      |   원피스/스커트
                  6001      |   바지/청바지
                  9001      |   악세사리
                ---------------------------
                """;
        System.out.println(categoryMenu);
    }

}
