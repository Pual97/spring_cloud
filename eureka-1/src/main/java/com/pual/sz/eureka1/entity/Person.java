package com.pual.sz.eureka1.entity;

import lombok.Data;

import java.util.List;

/**
 * @author pual
 * @version 1.0.0
 * @Description TODO
 * @createTime 2019年09月09日 11:11:00
 */
@Data
public class Person {

    private String name;
    private String age;
    private String tel;

    private List<Person> list;





}
