package com.oopssinsa.view;

import com.oopssinsa.model.dto.AccountDto;
import com.oopssinsa.model.dto.IbDetailDto;
import com.oopssinsa.model.dto.ProductDto;

import java.util.List;
import java.util.Objects;

public class ResultView {
    public static void displayInsertProductResult(String type, int result) {
        System.out.println("> 📢📢📢 " + type + " " + (result > 0 ? "성공!" : "실패!") + "📢📢📢");
    }

    public static void displayIbRequestResult(String type, int result) {
        System.out.println("> 📢📢📢 " + type + " " + (result > 0 ? "성공!" : "실패!") + "📢📢📢");
    }

    public static void displayMenu(AccountDto accountDto) {
        if(accountDto == null) {
            System.out.println("등록되지 않은 사용자 입니다.");
        } else if (!Objects.equals(accountDto.getRole(), "BM")) {
            System.out.println("브랜드 매니저만 이용할 수 있습니다.");
        } else {
            System.out.println(accountDto.getName() + "님 로그인 완료. 환영합니다!!!");
        }

    }

    public static void displayIbDetailList(List<IbDetailDto> list) {
        if (list.isEmpty()) {
            System.out.println("> 😅😅😅 조회된 입고 요청이 없습니다. 😅😅😅");
        } else {
            System.out.println("------------------------------------------------------------------------------------------------");
            System.out.printf("%s\t %-10s\t %-10s\t %-10s\t %-12s\t %-10s\t %-10s\t %-10s\n", "id", "manufacture_id", "product_id", "login_id", "quantity", "ib_date", "completion_date", "status");
            System.out.println("------------------------------------------------------------------------------------------------");
            for(IbDetailDto ibDetailDto : list) {
                System.out.printf("%d\t %-15s\t %-8s\t %-10s\t %-7d\t %-1s\t %-15s\t %-10s\n",
                        ibDetailDto.getId(),
                        ibDetailDto.getManufactureId(),
                        ibDetailDto.getProductId(),
                        ibDetailDto.getLoginId(),
                        ibDetailDto.getQuantity(),
                        ibDetailDto.getIbDate(),
                        ibDetailDto.getCompletionDate(),
                        ibDetailDto.getStatus()
                );
            }
            System.out.println("------------------------------------------------------------------------------------------------");
            System.out.println();
        }
    }

    public static void displayObRequestResult(String type, int result) {
        System.out.println("> 📢📢📢 " + type + " " + (result > 0 ? "성공!" : "실패!") + "📢📢📢");
    }

    public static void displayProductList(List<ProductDto> list) {
        if (list.isEmpty()) {
            System.out.println("> 😅😅😅 조회된 입고 요청이 없습니다. 😅😅😅");
        } else {
            System.out.println("📦 현재 등록된 상품 리스트");
            System.out.println("---------------------------------------------------------------------------------------------------------------");
            System.out.printf("%s\t %-10s\t %-20s\t %-32s\t %-10s\t %-10s\t %-10s\n", "id", "brandId", "categoryId", "name", "size", "color", "volume");
            System.out.println("---------------------------------------------------------------------------------------------------------------");
            for (ProductDto productDto : list) {
                System.out.printf("%s\t %-10d\t %-10d\t %-40s\t %-10s\t %-10s\t %-10d\n",
                        productDto.getId(),
                        productDto.getBrandId(),
                        productDto.getCategoryId(),
                        productDto.getName(),
                        productDto.getSize(),
                        productDto.getColor(),
                        productDto.getVolume()
                );
            }
            System.out.println("---------------------------------------------------------------------------------------------------------------");
        }


    }
}
