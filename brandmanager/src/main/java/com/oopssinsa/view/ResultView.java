package com.oopssinsa.view;

public class ResultView {
    public static void displayInsertProductResult(String type, int result) {
        System.out.println("> 📢📢📢 " + type + " " + (result > 0 ? "성공!" : "실패!") + "📢📢📢");
    }

    public static void displayIbRequestResult(String type, int result) {
        System.out.println("> 📢📢📢 " + type + " " + (result > 0 ? "성공!" : "실패!") + "📢📢📢");
    }

}
