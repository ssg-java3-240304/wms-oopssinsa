package com.oopssinsa.controller;

import com.oopssinsa.model.dto.IbDatailDto;
import com.oopssinsa.model.dto.ProductDto;
import com.oopssinsa.model.service.MenuService;
import com.oopssinsa.view.ResultView;

public class MenuController {
    private MenuService menuService = new MenuService();

    public void insertProduct(ProductDto productDto) {
        int result = menuService.insertProduct(productDto);
        ResultView.displayInsertProductResult("상품 등록", result);
    }

    public void ibRequest(IbDatailDto ibDatailDto) {
        int result = menuService.ibRequest(ibDatailDto);
        ResultView.displayIbRequestResult("입고 요청", result);
    }
}
