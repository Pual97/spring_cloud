package com.pual.sz.eureka1.reflect;

import com.pual.sz.eureka1.entity.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @author pual
 * @version 1.0.0
 * @Description TODO
 * @createTime 2019年09月09日 11:18:00
 */
public class PersonReflect {


    public static void main(String[] args) {
        try {
            Class<Person> personClass = Person.class;
            Constructor<Person> constructor = Person.class.getConstructor();
            Person person = constructor.newInstance();

            Method setName = personClass.getMethod("setName", String.class);
            setName.invoke(person,"born");

            Method getName = personClass.getMethod("getName");
            System.out.println(getName.invoke(person));


            Method getList = personClass.getMethod("getList");
            List invoke = (List) getList.invoke(person);
            System.out.println(invoke.size());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
