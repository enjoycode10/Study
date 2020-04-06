package com.okgo.mybatis.model;

/**
 * @author Shawn
 * @date 2020/4/6 17:57
 * @title Function
 */
public class User {
    private Integer id;
    private String name;
    private Byte gender;
    private Integer age;
    private String telephone;
    private String registerMode;
    private String thirdPartyId;

    public User() {
    }

    public User(Integer id, String name, Byte gender, Integer age, String telephone) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.telephone = telephone;
    }

    public User(Integer id, String name, Byte gender, Integer age, String telephone, String registerMode, String thirdPartyId) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.telephone = telephone;
        this.registerMode = registerMode;
        this.thirdPartyId = thirdPartyId;
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

    public Byte getGender() {
        return gender;
    }

    public void setGender(Byte gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getRegisterMode() {
        return registerMode;
    }

    public void setRegisterMode(String registerMode) {
        this.registerMode = registerMode;
    }

    public String getThirdPartyId() {
        return thirdPartyId;
    }

    public void setThirdPartyId(String thirdPartyId) {
        this.thirdPartyId = thirdPartyId;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", telephone='" + telephone + '\'' +
                ", registerMode='" + registerMode + '\'' +
                ", thirdPartyId='" + thirdPartyId + '\'' +
                '}';
    }
}
