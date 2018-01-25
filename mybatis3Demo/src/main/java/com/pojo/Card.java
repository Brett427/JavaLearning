package com.pojo;

/**
 * Created by brett on 2017/8/12.
 */
public class Card {
    private Integer id;
    private String code;

    public  Card(){

    }

    public Card(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
