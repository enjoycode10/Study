package com.okgo.principle.principle.demeter;

import java.util.ArrayList;
import java.util.List;

//客户端
public class Demeter1 {

    public static void main(String[] args) {
        SchoolManager schoolManager = new SchoolManager();
        schoolManager.printAllEmployee(new CollegeManager());
    }

}


//总部员工
class Employee {
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}


//学院员工
class CollegeEmployee {
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}


//管理类管理
class CollegeManager {
    //返回学院的所有员工
    public List<CollegeEmployee> getAllEmployee() {
        List<CollegeEmployee> list = new ArrayList<CollegeEmployee>();
        for (int i = 0; i < 10; i++) { //增加10个员工
            CollegeEmployee emp = new CollegeEmployee();
            emp.setId("学院员工 id= " + i);
            list.add(emp);
        }
        return list;
    }
}

//学校管理类

//SchoolManager
// 		直接朋友：Employee, CollegeManager
//		间接朋友：CollegeEmployee 未出现在成员变量，方法参数，返回值类型
class SchoolManager {
    //返回学校总部的员工
    public List<Employee> getAllEmployee() {
        List<Employee> list = new ArrayList<Employee>();

        for (int i = 0; i < 5; i++) { //��������������5��Ա���� list
            Employee emp = new Employee();
            emp.setId("总部员工 id= " + i);
            list.add(emp);
        }
        return list;
    }

    //该方法完成输出学校总部和学院员工信息的方法(id)
    void printAllEmployee(CollegeManager sub) {

        //分析问题
        //1. CollegeEmployee 不是  SchoolManager 直接朋友
        //2. CollegeEmployee 是以局部变量的方式出现在 SchoolManager
        //3. 违反了demeter法则

        List<CollegeEmployee> list1 = sub.getAllEmployee();
        System.out.println("------------学院员工------------");
        for (CollegeEmployee e : list1) {
            System.out.println(e.getId());
        }

        List<Employee> list2 = this.getAllEmployee();
        System.out.println("------------总部员工------------");
        for (Employee e : list2) {
            System.out.println(e.getId());
        }
    }
}
