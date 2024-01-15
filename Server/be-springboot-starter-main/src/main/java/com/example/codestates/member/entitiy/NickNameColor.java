package com.example.codestates.member.entitiy;


public enum NickNameColor {
    WHITE("#FFFFFF"), //흰색
    RED("#FF0000"), // 빨간색
    GREEN("#00FF00"), // 녹색
    BLUE("#0000FF"), // 파란색
    YELLOW("#FFFF00"), // 노란색
    PURPLE("#FF00FF"), // 보라색
    CYAN("#00FFFF"), // 청록색
    BLACK("#000000"); // 검정색

    private String code;
    NickNameColor(String code){
        this.code =code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
