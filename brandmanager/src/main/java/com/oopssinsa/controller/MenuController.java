package com.oopssinsa.controller;

import com.oopssinsa.model.dto.ProductDto;
import com.oopssinsa.model.service.MenuService;
import com.oopssinsa.view.ResultView;

public class MenuController {
    private MenuService menuService = new MenuService();

    public void insertProduct(ProductDto productDto) {
        int result = menuService.insertProduct(productDto);
        ResultView.displayResult("상품 등록", result);
    }
}
