package com.okgo.javaapi.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author Shawn
 * @date 2020/12/19 21:50
 * @title Function
 *
 * 排序操作
 * void reverse(List list)//反转
 * void shuffle(List list)//随机排序
 * void sort(List list)//按自然排序的升序排序
 * void sort(List list, Comparator c)//定制排序，由Comparator控制排序逻辑
 * void swap(List list, int i , int j)//交换两个索引位置的元素
 * void rotate(List list, int distance)//旋转。当distance为正数时，将list后distance个元素整体移到前面。当distance为负数时，将 list的前distance个元素整体移到后面
 *
 * 查找,替换操作
 * int binarySearch(List list, Object key)//对List进行二分查找，返回索引，注意List必须是有序的
 * int max(Collection coll)//根据元素的自然顺序，返回最大的元素。 类比int min(Collection coll)
 * int max(Collection coll, Comparator c)//根据定制排序，返回最大元素，排序规则由Comparatator类控制。类比int min(Collection coll, Comparator c)
 * void fill(List list, Object obj)//用指定的元素代替指定list中的所有元素。
 * int frequency(Collection c, Object o)//统计元素出现次数
 * int indexOfSubList(List list, List target)//统计target在list中第一次出现的索引，找不到则返回-1，类比int lastIndexOfSubList(List source, list target).
 * boolean replaceAll(List list, Object oldVal, Object newVal), 用新元素替换旧元素
 *
 * 同步控制
 * synchronizedCollection(Collection<T>  c) //返回指定 collection 支持的同步（线程安全的）collection。
 * synchronizedList(List<T> list)//返回指定列表支持的同步（线程安全的）List。
 * synchronizedMap(Map<K,V> m) //返回由指定映射支持的同步（线程安全的）Map。
 * synchronizedSet(Set<T> s) //返回指定 set 支持的同步（线程安全的）set。
 */
public class CollectionsTest {
    public static void main(String[] args) {


        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(9);
        list.add(7);
        list.add(7);
        list.add(7);
        list.add(7);

        //System.out.println(list);
        //Collections.rotate(list, 2);
        //System.out.println(list);
        //Collections.rotate(list, -2);
        //System.out.println(list);
        //Collections.reverse(list);
        //System.out.println(list);
        //Collections.shuffle(list);
        //System.out.println(list);

        //Collections.sort(list);
        //System.out.println(list);
        //System.out.println(Collections.binarySearch(list, 2));
        //System.out.println(Collections.frequency(list,7));


    }
}
