package com.oopssinsa.view;

import com.oopssinsa.model.dto.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
            System.out.printf("%s\t %-10s\t %-10s\t %-10s\t %-10s\t %-10s\t %-10s\t %-10s\n", "id", "manufacture_id", "product_id", "login_id", "quantity", "ib_date", "completion_date", "status");
            System.out.println("------------------------------------------------------------------------------------------------");
            for(IbDetailDto ibDetailDto : list) {
                System.out.printf("%d\t %-10s\t %-10s\t %-10s\t %-10d\t %-15s\t %-10s\t %-10s\n",
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
            System.out.println("> 😅😅😅 등록된 상품이 없습니다. 😅😅😅");
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

    public static void displayObDetailList(List<ObDto> list) {
//        Map<String, String> map = new HashMap<>();
//        map.put("W", "출고대기");
//        map.put("P", "출고진행");
//        map.put("S", "출고완료");
//        map.put("F", "출고실패");
//        map.put("N", "운송장 대기");

        if (list.isEmpty()) {
            System.out.println("> 😅😅😅 조회된 출고 요청이 없습니다. 😅😅😅");
        } else {
            System.out.println("------------------------------------------------------------------------------------------------");
            System.out.printf("%s\t %-10s\t %-10s\t %-10s\t %-10s\t %-10s\t %-10s\n", "menufacture_date", "ob_id", "product_id", "quantity", "status", "completion_date", "tracking_number");
            System.out.println("------------------------------------------------------------------------------------------------");
            for(ObDto obDto : list) {
                System.out.printf("%s\t %-10d\t %-10s\t %-10d\t %-10s\t %-15s\t %-10d\n",
                        obDto.getMenufactureDate(),
                        obDto.getObId(),
                        obDto.getProductId(),
                        obDto.getQuantity(),
                        obDto.getStatus(),
                        obDto.getCompletionDate(),
                        obDto.getTrackingNumber()
                );
            }
            System.out.println("------------------------------------------------------------------------------------------------");
            System.out.println();
        }
    }

    public static void desplayStockDetailList(List<StockListDto> list) {
        System.out.println();
        if (list.isEmpty()) {
            System.out.println("> 😅😅😅 조회된 재고내역이 없습니다. 😅😅😅");
        } else {
            System.out.println("📦 현재 등록된 전체 재고 리스트");
            System.out.println("------------------------------------------------------------------------------------------------");
            System.out.printf("%-10s\t %-10s\t %-10s\t %-13s\t %-17s\t  %-10s\t %-10s\t %-10s\n", "manufactureDate", "productId", "quantity", "date", "name", "size", "color", "volume");
            System.out.println("------------------------------------------------------------------------------------------------");
            for(StockListDto stockListDto : list) {
                System.out.printf("%-15s\t %-10s\t %-10d\t %-13s\t %-12s\t %-10s\t %-10s\t %-10s\n",
                        stockListDto.getManufactureDate(),
                        stockListDto.getProductId(),
                        stockListDto.getQuantity(),
                        stockListDto.getDate(),
                        stockListDto.getName(),
                        stockListDto.getSize(),
                        stockListDto.getColor(),
                        stockListDto.getVolume()
                );
            }
            System.out.println("------------------------------------------------------------------------------------------------");
            System.out.println();
        }
    }

    public static void desplayStockByCategoryIdList(List<StockListDto> list) {
        System.out.println();
        if (list.isEmpty()) {
            System.out.println("> 😅😅😅 조회된 재고내역이 없습니다. 😅😅😅");
        } else {
            System.out.println("📦 현재 등록된 재고 리스트");
            System.out.println("------------------------------------------------------------------------------------------------");
            System.out.printf("%-10s\t %-10s\t %-10s\t %-13s\t %-17s\t  %-10s\t %-10s\t %-10s\n", "manufactureDate", "productId", "quantity", "date", "name", "size", "color", "volume");
            System.out.println("------------------------------------------------------------------------------------------------");
            for(StockListDto stockListDto : list) {
                System.out.printf("%-15s\t %-10s\t %-10d\t %-13s\t %-12s\t %-10s\t %-10s\t %-10s\n",
                        stockListDto.getManufactureDate(),
                        stockListDto.getProductId(),
                        stockListDto.getQuantity(),
                        stockListDto.getDate(),
                        stockListDto.getName(),
                        stockListDto.getSize(),
                        stockListDto.getColor(),
                        stockListDto.getVolume()
                );
            }
            System.out.println("------------------------------------------------------------------------------------------------");
            System.out.println();
        }
    }

    public static void desplayStockByProductIdList(List<StockListDto> list) {
        System.out.println();
        if (list.isEmpty()) {
            System.out.println("> 😅😅😅 조회된 재고내역이 없습니다. 😅😅😅");
        } else {
            System.out.println("📦 현재 등록된 재고 리스트");
            System.out.println("------------------------------------------------------------------------------------------------");
            System.out.printf("%-10s\t %-10s\t %-10s\t %-13s\t %-17s\t  %-10s\t %-10s\t %-10s\n", "manufactureDate", "productId", "quantity", "date", "name", "size", "color", "volume");
            System.out.println("------------------------------------------------------------------------------------------------");
            for(StockListDto stockListDto : list) {
                System.out.printf("%-15s\t %-10s\t %-10d\t %-13s\t %-12s\t %-10s\t %-10s\t %-10s\n",
                        stockListDto.getManufactureDate(),
                        stockListDto.getProductId(),
                        stockListDto.getQuantity(),
                        stockListDto.getDate(),
                        stockListDto.getName(),
                        stockListDto.getSize(),
                        stockListDto.getColor(),
                        stockListDto.getVolume()
                );
            }
            System.out.println("------------------------------------------------------------------------------------------------");
            System.out.println();
        }
    }
}
