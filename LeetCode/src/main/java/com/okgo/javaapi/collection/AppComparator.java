package com.okgo.javaapi.collection;

import java.util.Comparator;

/**
 * @author Shawn
 * @date 2020/12/16 22:05
 * @title Function
 */
//自定义App类的比较器：
public class AppComparator implements Comparator<App> {

    //比较方法：先比较年龄，年龄若相同在比较名字长度；
    public int compare(App app1, App app2) {
        int num = app1.getAge() - app2.getAge();
        return num == 0 ? app1.getName().length() - app2.getName().length() : num;
    }
}
