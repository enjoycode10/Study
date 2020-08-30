package com.okgo.algo.sort;

/**
 * @author Shawn
 * @date 2020/8/30 10:50
 * @title Function
 */
public class Sort {
    public static void bubbleSort(int[] data) {
        int arrayLength = data.length;
        for (int i = 1; i < arrayLength; i++) {//第i次排序
            for (int j = 0; j < arrayLength - i; j++) {//从索引为j的数开始
                if (data[j] > data[j + 1]) { //相邻元素两两对比
                    int temp = data[j + 1];  // 元素交换
                    data[j + 1] = data[j];
                    data[j] = temp;
                }
            }
            System.out.println("第" + i + "次排序：\n" + java.util.Arrays.toString(data));
        }
    }

    public static void quickSort(int[] data) {
        quickSort(data, 0, data.length-1);
    }

    /**
     * 递归：
     *      递归第一个步骤：明确函数要做什么
     *      递归第二个步骤：明确递归的结束（退出递归）条件
     *      递归的第三个步骤：找到函数的递归部分
     * @param data
     * @param low
     * @param high
     */
    public static void quickSort(int[] data, int low, int high) {
        if (low > high) {
            return; // 递归停止条件
        }
        //i是左指针，j是右指针，index就是基准位上的值，temp
        int i = low, j = high, index = data[low], temp;
        System.out.println("基准位：" + index);
        while (i < j) {
            //先看右边，依次往左递减
            while (index <= data[j] && i < j) {
                j--;
            }
            //再看左边，依次往右递增
            while (index >= data[i] && i < j) {
                i++;
            }
            //如果满足条件则交换
            if (i < j) {
                System.out.println("交换：" + data[i] + "和" + data[j]);
                temp = data[j];
                data[j] = data[i];
                data[i] = temp;
                System.out.println(java.util.Arrays.toString(data));
            }
        }
        //最后将基准位与i和j相等位置的数字交换（基准位的值置中）
        System.out.println("基准位" + index + "和i、j相遇的位置" + data[i] + "交换");
        data[low] = data[i];
        data[i] = index;
        System.out.println(java.util.Arrays.toString(data));
        //递归调用左半数组
        quickSort(data, low, j - 1);
        //递归调用右半数组
        quickSort(data, j + 1, high);
    }

    public static void mergeSort(int[] data) {
        sort(data, 0, data.length - 1);
    }
    public static void sort(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }
    public static void merge(int[] arr, int l, int mid, int r) {
        int[] temp = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        // 比较左右两部分的元素，哪个小，把那个元素填入temp中
        while (p1 <= mid && p2 <= r) {
            temp[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        // 上面的循环退出后，把剩余的元素依次填入到temp中
        // 以下两个while只有一个会执行
        while (p1 <= mid) {
            temp[i++] = arr[p1++];
        }
        while (p2 <= r) {
            temp[i++] = arr[p2++];
        }
        // 把最终的排序的结果复制给原数组
        for (i = 0; i < temp.length; i++) {
            arr[l + i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] data = { 3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        System.out.println("排序之前：\n" + java.util.Arrays.toString(data));
        //bubbleSort(data);
        //quickSort(data);
        mergeSort(data);
        System.out.println("排序之后：\n" + java.util.Arrays.toString(data));
    }
}
