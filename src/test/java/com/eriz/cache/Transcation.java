package com.eriz.cache;

import com.eriz.Application;
import com.eriz.sys.domain.UserDO;
import com.eriz.sys.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class Transcation {

    public static void sort2(int[] list, int low, int high) {
        //7 8 1 6 4 3 9 2 13
        //lo              hi
        int key = list[low];
        int start = low;
        int end = high;
        while (start < end) {
            //hi
            while (start < end && key <= list[end]) {
                end--;
            }
            if (key > list[end]) {
                int temp = list[start];
                list[start] = list[end];
                list[end] = temp;
            }
            //lo
            while (start < end && key >= list[start]) {
                start++;
            }
            if (key < list[start]) {
                int temp = list[end];
                list[end] = list[start];
                list[start] = temp;
            }
        }
        if (start > low) {
            sort2(list, low, start - 1);
        }
        if (end < high) {
            sort2(list, end + 1, high);
        }
    }

    public static int partition(int[] array, int lo, int hi) {
        //固定的切分方式
        int key = array[lo];
        while (lo < hi) {
            while (array[hi] >= key && hi > lo) {//从后半部分向前扫描
                hi--;
            }
            array[lo] = array[hi];
            while (array[lo] <= key && hi > lo) {//从前半部分向后扫描
                lo++;
            }
            array[hi] = array[lo];
        }
        array[hi] = key;
        return hi;
    }

    public static void sort(int[] array, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int index = partition(array, lo, hi);
        sort(array, lo, index - 1);
        sort(array, index + 1, hi);
    }

    public static void main(String[] args) {
        System.out.println("Hello World");
        int[] a = {7, 8, 1, 6, 4, 3, 9, 2, 13};
        int start = 0;
        int end = a.length - 1;
        sort(a, start, end);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ",");
        }

        System.out.println();
        int i = 1;
        int j1 = i++;
        i = i++;
        System.out.println("j1=" + j1); // 输出 j1=1
        System.out.println("i=" + i); // 输出 i=2

    }

    public static void sort11(int[] a, int low, int high) {
        int start = low;
        int end = high;
        int key = a[low];


        while (end > start) {
            //从后往前比较
            while (end > start && a[end] >= key) {  //如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较
                end--;
            }
            if (a[end] <= key) {
                int temp = a[end];
                a[end] = a[start];
                a[start] = temp;
            }
            //从前往后比较
            while (end > start && a[start] <= key) {//如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置
                start++;
            }
            if (a[start] >= key) {
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
            }
            //此时第一次循环比较结束，关键值的位置已经确定了。左边的值都比关键值小，右边的值都比关键值大，但是两边的顺序还有可能是不一样的，进行下面的递归调用
        }
        //递归
        if (start > low) {
            sort(a, low, start - 1);
        }//左边序列。第一个索引位置到关键值索引-1
        if (end < high) {
            sort(a, end + 1, high);
        }//右边序列。从关键值索引+1到最后一个
    }
}




