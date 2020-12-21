package com.okgo.javaapi.collection;

/**
 * @author Shawn
 * @date 2020/12/16 22:03
 * @title Function
 */
public class App implements Comparable<App>{
    private String name;
    private Integer age;
    public App(){}
    public App(String name,Integer age){
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    //自定义比较：先比较name的长度，在比较age的大小；
    public int compareTo(App app) {
        //比较name的长度：
        int num = this.name.length() - app.name.length();
        //如果name长度一样，则比较年龄的大小：
        return num == 0 ? this.age - app.age : num;
    }
    @Override
    public String toString() {
        return "App{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
