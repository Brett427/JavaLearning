package com.pojo;

/**
 * Created by brett on 2017/8/12.
 */
public class Person {
    private Integer id;
    private String name;
    private String sex;
    private Integer age;
    private Card card;

    public Person(String name, String sex, Integer age, Card card) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.card = card;
    }
    public Person()
    {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
