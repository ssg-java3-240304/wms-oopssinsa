package com.oopssinsa.controller;

import com.oopssinsa.model.dto.*;
import com.oopssinsa.model.service.MenuService;
import com.oopssinsa.view.MenuView;
import com.oopssinsa.view.ResultView;

import java.util.List;

public class MenuController {
    private MenuService menuService = new MenuService();

    public void insertProduct(ProductDto productDto) {
        int result = menuService.insertProduct(productDto);
        ResultView.displayInsertProductResult("상품 등록", result);
    }

    public void ibRequest(IbDetailDto ibDetailDto) {
        int result = menuService.ibRequest(ibDetailDto);
        ResultView.displayIbRequestResult("입고 요청", result);
    }


    public AccountDto login(String id, String password) {
        try {
            AccountDto accountDto = menuService.login(id, password);
            ResultView.displayMenu(accountDto);
            return accountDto;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public void findByUserId(String id) {
        try {
            List<IbDetailDto> list = menuService.findByUserId(id);
            ResultView.displayIbDetailList(list);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void obRequest(ObDetailDto obDetailDto) {
        int result = menuService.obRequest(obDetailDto);
        ResultView.displayObRequestResult("출고 요청", result);
    }

    public void showProduct(long brandId) {
        List<ProductDto> list = menuService.showProduct(brandId);
        ResultView.displayProductList(list);
    }

    public void findObDetail(String userId) {
        // 조인하게되면 Dto를 합친걸로 만들어야 되나?
        try {
            List<ObDto> list = menuService.findObDetail(userId);
            ResultView.displayObDetailList(list);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void findAllStockDetail(long brandId) {
        try {
            List<StockListDto> list = menuService.findAllStockDetail(brandId);
            ResultView.desplayStockDetailList(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void findStockByCategoryId(long brandId, long categoryId) {
        try {
            List<StockListDto> list = menuService.findStockByCategoryId(brandId, categoryId);
            ResultView.desplayStockByCategoryIdList(list);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void findStockByProductId(long brandId, String productId) {
        try {
            List<StockListDto> list = menuService.findStockByProductId(brandId, productId);
            ResultView.desplayStockByProductIdList(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
