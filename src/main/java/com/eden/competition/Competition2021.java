package com.eden.competition;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Competition2021 {

    /**
     * @Descriptionv5661. 替换隐藏数字得到的最晚时间
     * @author gexx
     * @Date 2021/1/24
     **/
    public static String maximumTime(String time) {
        char[] arr = time.toCharArray();
        if (arr[0] == '?' && arr[1] == '?') {
            arr[0] = '2';
            arr[1] = '3';
        } else if (arr[0] == '?') {
            if (arr[1] <= '3') {
                arr[0] = '2';
            } else {
                arr[0] = '1';
            }
        } else if (arr[1] == '?') {
            if (arr[0] <= '1') {
                arr[1] = '9';
            } else {
                arr[1] = '3';
            }
        }

        if (arr[3] == '?') {
            arr[3] = '5';
        }
        if (arr[4] == '?') {
            arr[4] = '9';
        }
        return new String(arr);


    }


    /**
     * @Description 5654. 盒子中小球的最大数量
     * @author gexx
     * @Date 2021/1/31
     **/
    public static int countBalls(int lowLimit, int highLimit) {
        Map<Integer, Integer> cap = new HashMap();
        for (int i = lowLimit; i <= highLimit; i++) {
            cap.put(sum(i), cap.getOrDefault(sum(i), 0) + 1);
        }
        int maxNum = 0;
        Iterator iterator = cap.keySet().iterator();
        while (iterator.hasNext()) {
            Integer key = (Integer) iterator.next();
            maxNum=Math.max(maxNum, cap.get(key));
        }


        return maxNum;
    }

    public static int sum(int n) {
        int sum = 0;
        while (n >= 10) {
            sum += n % 10;
            n /= 10;
        }
        sum += n;
        return sum;
    }

    public static void main(String[] args) {

        System.out.println(countBalls(1, 10));
        System.out.println(maximumTime("2?:?0"));
    }
}
