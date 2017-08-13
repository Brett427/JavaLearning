package com.pojo;

import java.util.List;

/**
 * Created by brett on 2017/8/12.
 */
public class Clazz {
    private Integer id;
    private String name;
    private String code;
    private List<Student> students;
    public Clazz(){

    }

    public Clazz(String name, String code, List<Student> students) {
        this.name = name;
        this.code = code;
        this.students = students;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", students=" + students +
                '}';
    }
}
