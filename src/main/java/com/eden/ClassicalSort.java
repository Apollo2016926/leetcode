package com.eden;

import java.util.Arrays;

/**
 * @Description: 经典排序
 * @Author gexx
 * @Date 2021/4/12
 * @Version V1.0
 **/
public class ClassicalSort {


    /**
     * @Description: 冒泡排序
     * @Author: gexx
     * @Date: 2021/4/12
     **/
    public static int[] BubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {

                if (arr[j - 1] > arr[j]) {
                    int tmp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }

        return arr;
    }

    /**
     * @Description: 选择排序
     * @Author: gexx
     * @Date: 2021/4/13
     **/
    public static int[] SelectionSort(int[] arr) {
        int minIndex, tmp;
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            tmp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tmp;
        }

        return arr;
    }
    /**
     * @Description: 插入排序
     * @Author: gexx
     * @Date: 2021/4/13
     **/
    public static int[] InsertionSort(int[] arr) {


        return arr;
    }
    public static void main(String[] args) {
        int arr[] = new int[] {3, 1, 2, 4};
//        System.out.println(Arrays.toString(BubbleSort(arr)));
        System.out.println(Arrays.toString(SelectionSort(arr)));
    }
}
