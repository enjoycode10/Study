package com.okgo.javaapi.generic;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Shawn
 * @date 2020/12/17 9:48
 * @title Function
 */
public class Test1 {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("abc");
        List<Integer> integerList = new ArrayList<>();
        integerList.add(123);

        //1. 类型擦除
        System.out.println(stringList.getClass().toGenericString());
        System.out.println(stringList.getClass().toString());
        System.out.println(stringList.getClass() == integerList.getClass()); //true: 说明泛型类型String和Integer都被擦除掉了，只剩下原始类型。

        //2. 通过反射添加其它类型元素
        try {
            integerList.getClass().getDeclaredMethod("add", Object.class).invoke(integerList, "abc"); //可以存储字符串：说明了Integer泛型实例在编译之后被擦除掉了，只保留了原始类型。
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < integerList.size(); i++) {
            System.out.println(integerList.get(i));
        }

    }
}
