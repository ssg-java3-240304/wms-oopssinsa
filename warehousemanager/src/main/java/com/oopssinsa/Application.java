package com.oopssinsa;

import com.oopssinsa.controller.Controller;
import com.oopssinsa.model.service.IbService;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller();

        controller.run();
        IbService ibService = new IbService();
//        System.out.println(ibService.findSectionByBrandId("1"));
//        ibService.findLocationByCategoryIdAndSectionId(
//                "1001", 'A');

    }
}
